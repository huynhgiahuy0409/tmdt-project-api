package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.CartItemDTO;
import com.javatpoint.ecormspringboot.common.dto.JWTDTO;
import com.javatpoint.ecormspringboot.common.dto.PendingItemDTO;
import com.javatpoint.ecormspringboot.common.dto.UserDTO;
import com.javatpoint.ecormspringboot.common.entity.*;
import com.javatpoint.ecormspringboot.common.request.AuthenticationRequest;
import com.javatpoint.ecormspringboot.common.request.ReAccountRequest;
import com.javatpoint.ecormspringboot.common.request.UserAccountRequest;
import com.javatpoint.ecormspringboot.common.service.*;
import com.javatpoint.ecormspringboot.common.service.imp.CustomUserDetailsService;
import com.javatpoint.ecormspringboot.common.util.JWTUtil;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import com.javatpoint.ecormspringboot.response.AuthenticationResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private IJWTService jwtService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ICartItemService cartItemService;
    @Autowired
    private IPendingItemService pendingItemService;
    @Autowired
    private ITokenAuthenticationService tokenAuthenticationService;
    @Autowired
    private ObjectMapperUtils om;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationRequest> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        UserDetails userDetail = null;
        userDetail = this.customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        if (userDetail != null && userDetail.getPassword().equals(authenticationRequest.getPassword())) {
            return ResponseEntity.ok(new AuthenticationRequest("A", "B"));
        } else {
            return null;
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccountRequest> registerUserAccount(@RequestBody UserAccountRequest registerAccountRequest) {
        UserAccountRequest account = this.userService.checkUsername(registerAccountRequest);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequest authenticationRequest) {
        UserDetails userDetails = null;
        userDetails = this.customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        if (userDetails != null && this.userService.checkPassword(userDetails.getPassword(), authenticationRequest.getPassword())) {
            String accessToken = this.jwtUtil.generateToken(userDetails, "access");
            String refreshToken = this.jwtUtil.generateToken(userDetails, "refresh");
            JWTEntity refreshJWTEntity = new JWTEntity();
            refreshJWTEntity.setToken(refreshToken);
            refreshJWTEntity.setTokenExpirationDate(this.jwtUtil.getExpirationDateFromToken(refreshToken));
            JWTEntity accessJWTEntity = new JWTEntity();
            accessJWTEntity.setToken(refreshToken);
            accessJWTEntity.setTokenExpirationDate(this.jwtUtil.getExpirationDateFromToken(accessToken));
            this.jwtService.save(refreshJWTEntity);
            UserEntity userEntity = this.userService.findByUsername(authenticationRequest.getUsername());
            CartEntity userCartEntity = userEntity.getCart();
            List<CartItemEntity> cartItemEntities = this.cartItemService.findAllByCart(userCartEntity, new Sort(Sort.Direction.DESC, "modifiedDate"));
            for (CartItemEntity cartItemEntity : cartItemEntities) {
                System.out.println(cartItemEntity.getId());
                cartItemEntity.setPendingItems(pendingItemService.findAllByCartItem(cartItemEntity, new Sort(Sort.Direction.DESC, "modifiedDate")));
                for (PendingItemEntity pendingItem : cartItemEntity.getPendingItems()) {
                    System.out.println(pendingItem.getProduct().getId());
                }
            }
            List<CartItemDTO> cartItemDTOS = this.om.mapAll(cartItemEntities, CartItemDTO.class);
            UserDTO userDTO = this.modelMapper.map(userEntity, UserDTO.class);
            userDTO.getCart().setCartItems(cartItemDTOS);
            JWTDTO accessJWTDTO = this.modelMapper.map(accessJWTEntity, JWTDTO.class);
            JWTDTO refreshJWTDTO = this.modelMapper.map(refreshJWTEntity, JWTDTO.class);
            return ResponseEntity.ok(new AuthenticationResponse(userDTO, accessJWTDTO, refreshJWTDTO));
        }
        return null;
    }

    @GetMapping("/refresh-access-token")
    public ResponseEntity<AuthenticationResponse> refreshAccessToken(HttpServletRequest request) {
        String refreshToken = this.tokenAuthenticationService.getTokenFromHeader(request);
        JWTEntity foundRefreshToken = this.jwtService.findByToken(refreshToken);
        if (foundRefreshToken != null) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
            UserEntity userEntity = this.userService.findByUsername(username);
            String newRefreshToken = this.jwtUtil.generateToken(userDetails, "refresh");
            String newAccessToken = this.jwtUtil.generateToken(userDetails, "access");
            Date expiredNewRefreshToken = this.jwtUtil.getExpirationDateFromToken(newRefreshToken);
            Date expiredNewAccessToken = this.jwtUtil.getExpirationDateFromToken(newAccessToken);
            foundRefreshToken.setToken(newRefreshToken);
            foundRefreshToken.setTokenExpirationDate(expiredNewRefreshToken);
            this.jwtService.save(foundRefreshToken);
            JWTEntity newAccessTokenEntity = new JWTEntity();
            newAccessTokenEntity.setToken(newAccessToken);
            newAccessTokenEntity.setTokenExpirationDate(expiredNewAccessToken);
            CartEntity userCartEntity = userEntity.getCart();
            List<CartItemEntity> cartItemEntities = this.cartItemService.findAllByCart(userCartEntity, new Sort(Sort.Direction.DESC, "modifiedDate"));
            for (CartItemEntity cartItemEntity : cartItemEntities) {
                System.out.println(cartItemEntity.getId());
                cartItemEntity.setPendingItems(pendingItemService.findAllByCartItem(cartItemEntity, new Sort(Sort.Direction.DESC, "modifiedDate")));
                for (PendingItemEntity pendingItem : cartItemEntity.getPendingItems()) {
                    System.out.println(pendingItem.getProduct().getId());
                }
            }
            List<CartItemDTO> cartItemDTOS = this.om.mapAll(cartItemEntities, CartItemDTO.class);
            for (CartItemDTO cartItemDTO : cartItemDTOS) {
                System.out.println(cartItemDTO.getId());
                for (PendingItemDTO pendingItem : cartItemDTO.getPendingItems()) {
                    System.out.println(pendingItem.getProduct().getId());
                }
            }
            UserDTO userDTO = this.modelMapper.map(userEntity, UserDTO.class);
            userDTO.getCart().setCartItems(cartItemDTOS);
            return ResponseEntity.ok(new AuthenticationResponse(userDTO, this.modelMapper.map(newAccessTokenEntity, JWTDTO.class), this.modelMapper.map(foundRefreshToken, JWTDTO.class)));
        }
        return null;
    }

    @GetMapping(value = "/revoke-token")
    public Long revokeToken(HttpServletRequest request) {
        String token = this.tokenAuthenticationService.getTokenFromHeader(request);
        Long recordId = this.jwtService.removeByToken(token);
        System.out.println(recordId);
        if (recordId != null && recordId.longValue() != -1) {
            return recordId.longValue();
        } else {
            return new Long(-1).longValue();
        }
    }

    @GetMapping(value = "/check-user")
    public ResponseEntity<Boolean> checkUser(@RequestParam String username) {
        if (!StringUtils.isEmpty(username)) {
            String refactorUsername = StringUtils.trimAllWhitespace(username);
            UserEntity foundUser = this.userService.findByUsername(refactorUsername);
            if (foundUser != null) {
                return ResponseEntity.ok(true);
            }
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(false);
    }
}

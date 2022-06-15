package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.JWTDTO;
import com.javatpoint.ecormspringboot.common.dto.UserDTO;
import com.javatpoint.ecormspringboot.common.entity.JWTEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.request.AuthenticationRequest;
import com.javatpoint.ecormspringboot.common.request.ReAccountRequest;
import com.javatpoint.ecormspringboot.common.request.RegisterAccountRequest;
import com.javatpoint.ecormspringboot.common.service.IJWTService;
import com.javatpoint.ecormspringboot.common.service.ITokenAuthenticationService;
import com.javatpoint.ecormspringboot.common.service.IUserService;
import com.javatpoint.ecormspringboot.common.service.imp.CustomUserDetailsService;
import com.javatpoint.ecormspringboot.common.util.JWTUtil;
import com.javatpoint.ecormspringboot.response.AuthenticationResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
    private ITokenAuthenticationService tokenAuthenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationRequest> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest){
        UserDetails userDetail = null;
        userDetail = this.customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        if (userDetail != null && userDetail.getPassword().equals(authenticationRequest.getPassword())) {
            return ResponseEntity.ok(new AuthenticationRequest("A","B"));
        }else {
            return null;
        }
    }
    @PostMapping("/register")
    public ResponseEntity<RegisterAccountRequest> registerUserAccount(@RequestBody RegisterAccountRequest registerAccountRequest){
        RegisterAccountRequest account = this.userService.checkUsername(registerAccountRequest);
           return ResponseEntity.ok(account);
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequest authenticationRequest){
        UserDetails userDetails = null;
        userDetails = this.customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        if(userDetails != null && this.userService.checkPassword(userDetails.getPassword(), authenticationRequest.getPassword())){
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
            UserDTO userDTO = this.modelMapper.map(userEntity, UserDTO.class);
            JWTDTO accessJWTDTO  = this.modelMapper.map(accessJWTEntity, JWTDTO.class);
            JWTDTO refreshJWTDTO = this.modelMapper.map(refreshJWTEntity, JWTDTO.class);
            return ResponseEntity.ok(new AuthenticationResponse(userDTO, accessJWTDTO, refreshJWTDTO));
        }
        return null;
    }

    @GetMapping("/refresh-access-token")
    public ResponseEntity<AuthenticationResponse> refreshAccessToken(HttpServletRequest request){
        String refreshToken = this.tokenAuthenticationService.getTokenFromHeader(request);
        JWTEntity foundRefreshToken = this.jwtService.findByToken(refreshToken);
        if(foundRefreshToken != null){
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
            UserEntity userEntity = this.userService.findByUsername(username);
            String newRefreshToken = this.jwtUtil.generateToken(userDetails,"refresh");
            String newAccessToken = this.jwtUtil.generateToken(userDetails,"access");
            Date expiredNewRefreshToken = this.jwtUtil.getExpirationDateFromToken(newRefreshToken);
            Date expiredNewAccessToken = this.jwtUtil.getExpirationDateFromToken(newAccessToken);
            foundRefreshToken.setToken(newRefreshToken);
            foundRefreshToken.setTokenExpirationDate(expiredNewRefreshToken);
            this.jwtService.save(foundRefreshToken);
            JWTEntity newAccessTokenEntity = new JWTEntity();
            newAccessTokenEntity.setToken(newAccessToken);
            newAccessTokenEntity.setTokenExpirationDate(expiredNewAccessToken);
            UserDTO userDTO = this.modelMapper.map(userEntity, UserDTO.class);
            return ResponseEntity.ok(new AuthenticationResponse(userDTO, this.modelMapper.map(newAccessTokenEntity, JWTDTO.class),this.modelMapper.map(foundRefreshToken, JWTDTO.class)));
        }
        return null;
    }
    @GetMapping(value = "/revoke-token")
    public Long revokeToken(HttpServletRequest request) {
        String token = this.tokenAuthenticationService.getTokenFromHeader(request);
        Long recordId = this.jwtService.removeByToken(token);
        System.out.println(recordId);
        if(recordId != null && recordId.longValue() != -1){
            return recordId.longValue();
        }else{
            return new Long(-1).longValue();
        }
    }
    @GetMapping(value = "/check-user")
    public ResponseEntity<Boolean> checkUser(@RequestParam String username){
        System.out.println(username);
        if (!StringUtils.isEmpty(username)){
            UserEntity foundUser = this.userService.findByUsername(username);
            if(foundUser != null){
                return ResponseEntity.ok(true);
            }
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(false);
    }
    @PostMapping(value = "/reset-password")
    public ResponseEntity<Boolean> resetPassoword(@RequestBody(required = true) ReAccountRequest reAccount){
       this.userService.resetPassword(reAccount.getUsername(), reAccount.getNewPassword());
        return ResponseEntity.ok(true);
    }
}

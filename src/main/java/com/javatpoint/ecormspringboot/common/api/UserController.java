package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.UserDTO;
import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.request.UserAccountRequest;
import com.javatpoint.ecormspringboot.common.service.imp.UserService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private ObjectMapperUtils om;
    @Autowired
    private ModelMapper mp;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/update")
    public ResponseEntity<UserDTO> fetchUser(@RequestBody UserDTO user) {
        this.mp.getConfiguration().setSkipNullEnabled(true);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity requestUser = this.mp.map(user, UserEntity.class);
        UserEntity findUser = this.userService.findByUsername(username);
        this.mp.map(requestUser, findUser);
        this.userService.save(findUser);
        UserDTO result = this.mp.map(findUser, UserDTO.class);
        return ResponseEntity.ok(result);
    }

    @PostMapping()
    public ResponseEntity<Boolean> updateUser(@RequestBody UserAccountRequest userAccountRequest) {
        UserEntity foundUserEntity = this.userService.findByUsername(userAccountRequest.getUsername());
        if (foundUserEntity == null) {
            foundUserEntity = new UserEntity();
            foundUserEntity.setUsername(userAccountRequest.getUsername());
            foundUserEntity.setPassword(this.passwordEncoder.encode(userAccountRequest.getPassword()));
            foundUserEntity.setFullName(userAccountRequest.getFullName());
            CartEntity cartEntity = new CartEntity();
            cartEntity.setUser(foundUserEntity);
            foundUserEntity.setCart(cartEntity);
            ShopEntity shopEntity = new ShopEntity();
            shopEntity.setName(foundUserEntity.getUsername());
            shopEntity.setUser(foundUserEntity);
            foundUserEntity.setShop(shopEntity);
        } else {
            System.out.println(userAccountRequest.getUsername());
            System.out.println(userAccountRequest.getPassword());
            System.out.println(foundUserEntity.getUsername());
            System.out.println(foundUserEntity.getPassword());
            System.out.println(this.passwordEncoder.encode(userAccountRequest.getPassword()));
            foundUserEntity.setPassword(this.passwordEncoder.encode(userAccountRequest.getPassword()));
        }
        UserEntity savedUserEntity = this.userService.save(foundUserEntity);
        return ResponseEntity.ok(true);
    }
}

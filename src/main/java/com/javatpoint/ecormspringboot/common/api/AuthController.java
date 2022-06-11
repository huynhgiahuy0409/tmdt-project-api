package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.entity.JWTEntity;
import com.javatpoint.ecormspringboot.common.request.AuthenticationRequest;
import com.javatpoint.ecormspringboot.common.request.RegisterAccountRequest;
import com.javatpoint.ecormspringboot.common.service.IUserService;
import com.javatpoint.ecormspringboot.common.service.imp.CustomUserDetailsService;
import com.javatpoint.ecormspringboot.common.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AuthController {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private IUserService userService;
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
        System.out.printf(this.userService.checkPassword(userDetails.getUsername(), authenticationRequest.getUsername()) + "");
        if(userDetails != null && this.userService.checkPassword(userDetails.getUsername(), authenticationRequest.getUsername())){
            String token = this.jwtUtil.generateToken(userDetails);
            System.out.printf(token + "");
            JWTEntity jwtEntity = new JWTEntity();
            jwtEntity.setToken(token);
            jwtEntity.setTokenExpirationDate(this.jwtUtil.getExpirationDateFromToken(token));
            this.tokenService.saveToken(jwtEntity);
            return null;
        }
        return null;
    }
}

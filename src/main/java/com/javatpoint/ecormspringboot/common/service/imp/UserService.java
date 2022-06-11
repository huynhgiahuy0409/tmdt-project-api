package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.repository.IUserRepository;
import com.javatpoint.ecormspringboot.common.request.AuthenticationRequest;
import com.javatpoint.ecormspringboot.common.request.RegisterAccountRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.javatpoint.ecormspringboot.common.service.IUserService;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public RegisterAccountRequest checkUsername(RegisterAccountRequest account) {
        UserEntity userCheck = this.userRepository.findByUsername(account.getUsername());
        return userCheck == null? account : null;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    public boolean checkPassword(String userDetailsPassword, String password){
        boolean isMatch = this.passwordEncoder.matches(password, userDetailsPassword);
        return isMatch;
    }
}

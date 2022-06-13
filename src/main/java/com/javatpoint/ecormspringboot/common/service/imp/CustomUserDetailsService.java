package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        User user = null;
        if (userEntity != null) {
            List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
            if (userEntity.getRole() != null) {
              roles.add(new SimpleGrantedAuthority(userEntity.getRole()));
            }
            user = new User(username, userEntity.getPassword(), roles);
            return user;
        }
        throw new UsernameNotFoundException("Tài khoản không tồn tại");
    }
}

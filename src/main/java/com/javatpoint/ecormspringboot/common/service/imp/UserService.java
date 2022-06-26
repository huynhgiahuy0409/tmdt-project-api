package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.repository.IUserRepository;
import com.javatpoint.ecormspringboot.common.request.UserAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javatpoint.ecormspringboot.common.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserAccountRequest checkUsername(UserAccountRequest account) {
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

    @Override
    public UserEntity findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public UserEntity resetPassword(String username, String newPassword) {
        UserEntity user = this.userRepository.findByUsername(username);
        user.setPassword(this.passwordEncoder.encode(newPassword));
        return this.userRepository.save(user);
    }

    @Override
    public UserEntity findById(long id) {
        return this.userRepository.findOne(id);
    }

}

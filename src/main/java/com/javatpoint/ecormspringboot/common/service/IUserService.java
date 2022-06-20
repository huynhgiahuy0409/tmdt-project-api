package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.request.AuthenticationRequest;
import com.javatpoint.ecormspringboot.common.request.ReAccountRequest;
import com.javatpoint.ecormspringboot.common.request.RegisterAccountRequest;

public interface IUserService {
    public RegisterAccountRequest checkUsername(RegisterAccountRequest account);
    public UserEntity save(UserEntity userEntity);
    public boolean checkPassword(String userDetailsPassword, String password);
    public UserEntity findByUsername(String username);
    public UserEntity resetPassword(String username, String newPassword);
    public UserEntity findById(long id);
}

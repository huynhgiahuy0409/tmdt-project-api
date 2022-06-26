package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.request.UserAccountRequest;

public interface IUserService {
    public UserAccountRequest checkUsername(UserAccountRequest account);
    public UserEntity save(UserEntity userEntity);
    public boolean checkPassword(String userDetailsPassword, String password);
    public UserEntity findByUsername(String username);
    public UserEntity resetPassword(String username, String newPassword);
    public UserEntity findById(long id);
}

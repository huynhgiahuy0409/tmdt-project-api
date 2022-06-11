package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.JWTEntity;

public interface IJWTService {
    JWTEntity save(JWTEntity token);
}

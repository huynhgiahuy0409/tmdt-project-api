package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.JWTEntity;
import org.springframework.stereotype.Service;

public interface IJWTService {
    JWTEntity save(JWTEntity token);

    JWTEntity findByToken(String token);

    Long removeByToken(String token);
}

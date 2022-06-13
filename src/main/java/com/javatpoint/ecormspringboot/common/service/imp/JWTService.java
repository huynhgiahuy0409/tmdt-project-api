package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.JWTEntity;
import com.javatpoint.ecormspringboot.common.repository.IJWTRepository;
import com.javatpoint.ecormspringboot.common.service.IJWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JWTService implements IJWTService {
    @Autowired
    private IJWTRepository jwtRepository;

    @Override
    public JWTEntity save(JWTEntity token) {
        return this.jwtRepository.save(token);
    }

    @Override
    public JWTEntity findByToken(String token) {
        return this.jwtRepository.findByToken(token);
    }

    @Override
    public Long removeByToken(String token) {
        return this.jwtRepository.removeByToken(token);
    }
}

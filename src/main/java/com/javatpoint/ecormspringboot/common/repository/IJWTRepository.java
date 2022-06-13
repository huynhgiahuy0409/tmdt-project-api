package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.JWTEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IJWTRepository extends JpaRepository<JWTEntity, Long> {
    JWTEntity findByToken(String token);
    @Transactional
    Long removeByToken(String token);
}

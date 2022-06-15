package com.javatpoint.ecormspringboot.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.ecormspringboot.common.entity.MaterialEntity;

public interface IMaterialRepository extends JpaRepository<MaterialEntity, Long> {
    MaterialEntity findByCode(String code);
}

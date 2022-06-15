package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
    BrandEntity findByCode(String code);
}

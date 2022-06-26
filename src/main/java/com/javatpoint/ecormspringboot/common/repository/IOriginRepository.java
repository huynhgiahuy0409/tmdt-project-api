package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.OriginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOriginRepository extends JpaRepository<OriginEntity, Long> {
    OriginEntity findByCode(String code);
}

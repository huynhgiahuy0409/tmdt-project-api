package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<StatusEntity, Long> {
    StatusEntity findByCode(String code);
}

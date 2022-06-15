package com.javatpoint.ecormspringboot.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.ecormspringboot.common.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCode(String code);
}

package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.ecormspringboot.common.entity.CategoryEntity;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCode(String code);

    List<CategoryEntity> findByProducts(List<ProductEntity> products);
}

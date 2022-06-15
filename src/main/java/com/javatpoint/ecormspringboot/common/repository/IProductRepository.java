package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
}

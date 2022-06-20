package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.PendingItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPendingItemRepository extends JpaRepository<PendingItemEntity, Long> {
    PendingItemEntity findByCartAndProduct(CartEntity cart, ProductEntity product);
}

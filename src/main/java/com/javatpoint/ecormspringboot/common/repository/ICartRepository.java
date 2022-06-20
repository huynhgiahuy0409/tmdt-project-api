package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<CartEntity, Long> {
    CartEntity findById(long id);
}

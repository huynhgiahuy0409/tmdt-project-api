package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.CartItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartItemRepository extends JpaRepository<CartItemEntity, Long> {
    public CartItemEntity findByCartAndShop(CartEntity cart, ShopEntity shop);
}

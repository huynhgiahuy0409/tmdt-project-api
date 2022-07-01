package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.CartItemEntity;
import com.javatpoint.ecormspringboot.common.entity.PendingItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ICartItemRepository extends JpaRepository<CartItemEntity, Long> {
    public CartItemEntity findByCartAndShop(CartEntity cart, ShopEntity shop);

    public List<CartItemEntity> findAllByCart(CartEntity cart, Sort sort);

}

package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.CartItemEntity;
import com.javatpoint.ecormspringboot.common.entity.PendingItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

public interface ICartItemService {
    CartItemEntity findByCartAndShop(CartEntity cart, ShopEntity shop);

    CartItemEntity save(CartItemEntity cartItem);

     List<CartItemEntity> findAllByCart(CartEntity cart, Sort sort);

}

package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.CartItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;

public interface ICartItemService {
    CartItemEntity findByCartAndShop(CartEntity cart, ShopEntity shop);
    CartItemEntity save(CartItemEntity cartItem);
}

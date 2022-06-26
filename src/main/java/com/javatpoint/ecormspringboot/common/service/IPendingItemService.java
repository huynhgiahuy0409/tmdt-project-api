package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.CartItemEntity;
import com.javatpoint.ecormspringboot.common.entity.PendingItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;

public interface IPendingItemService {
    PendingItemEntity findByCartItemAndProduct(CartItemEntity cartItem, ProductEntity product);
    PendingItemEntity save(PendingItemEntity pendingItem);
}

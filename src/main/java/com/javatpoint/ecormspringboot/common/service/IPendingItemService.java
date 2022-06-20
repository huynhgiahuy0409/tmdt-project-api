package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.PendingItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;

public interface IPendingItemService {
    PendingItemEntity findByCartAndProduct(CartEntity cart, ProductEntity product);
    PendingItemEntity save(PendingItemEntity pendingItem);
}

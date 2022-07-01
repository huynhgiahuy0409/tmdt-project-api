package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.CartItemEntity;
import com.javatpoint.ecormspringboot.common.entity.PendingItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;

public interface IPendingItemService {
    PendingItemEntity findByCartItemAndProduct(CartItemEntity cartItem, ProductEntity product);

    PendingItemEntity save(PendingItemEntity pendingItem);

    List<PendingItemEntity> findAllByCartItem(CartItemEntity cartItem, Sort sort);

    PendingItemEntity findOne(long id);

    void removeById(long id);
}

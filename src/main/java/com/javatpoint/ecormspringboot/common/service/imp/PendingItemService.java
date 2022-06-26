package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.CartItemEntity;
import com.javatpoint.ecormspringboot.common.entity.PendingItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.repository.IPendingItemRepository;
import com.javatpoint.ecormspringboot.common.service.IPendingItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PendingItemService implements IPendingItemService {
    @Autowired
    private IPendingItemRepository pendingItemRepository;


    @Override
    public PendingItemEntity findByCartItemAndProduct(CartItemEntity cartItem, ProductEntity product) {
        return this.pendingItemRepository.findByCartItemAndProduct(cartItem, product);
    }

    @Override
    public PendingItemEntity save(PendingItemEntity pendingItem) {
        return this.pendingItemRepository.save(pendingItem);
    }
}

package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.CartItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.repository.ICartItemRepository;
import com.javatpoint.ecormspringboot.common.service.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService implements ICartItemService {
    @Autowired
    private ICartItemRepository cartItemRepository;


    @Override
    public CartItemEntity findByCartAndShop(CartEntity cart, ShopEntity shop) {
        return this.cartItemRepository.findByCartAndShop(cart,shop);
    }

    @Override
    public CartItemEntity save(CartItemEntity cartItem) {
        return this.cartItemRepository.save(cartItem);
    }
}

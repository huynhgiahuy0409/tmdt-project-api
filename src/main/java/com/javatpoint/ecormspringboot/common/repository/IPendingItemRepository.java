package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.CartItemEntity;
import com.javatpoint.ecormspringboot.common.entity.PendingItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface IPendingItemRepository extends JpaRepository<PendingItemEntity, Long> {
    PendingItemEntity findByCartItemAndProduct(CartItemEntity cartItem, ProductEntity product);

    List<PendingItemEntity> findAllByCartItem(CartItemEntity cartItem, Sort sort);

    void removeById(long id);
}

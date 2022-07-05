package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.OrderEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;

import java.util.List;

public interface IOrderService {
    OrderEntity save(OrderEntity order);

    List<OrderEntity> findAll();

    List<OrderEntity> findAllByStatus(String status);

    List<OrderEntity> findAllByStatusAndShop(String status, ShopEntity shopEntity);

    OrderEntity findOne(long id);

    List<OrderEntity> findAllByShop(ShopEntity shopEntity);
}

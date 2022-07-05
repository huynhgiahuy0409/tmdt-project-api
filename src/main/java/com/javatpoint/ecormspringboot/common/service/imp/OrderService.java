package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.OrderEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.repository.IOrderRepository;
import com.javatpoint.ecormspringboot.common.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public OrderEntity save(OrderEntity order) {
        return this.orderRepository.save(order);
    }

    @Override
    public List<OrderEntity> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public List<OrderEntity> findAllByStatus(String status) {
        return this.orderRepository.findAllByStatus(status);
    }

    @Override
    public List<OrderEntity> findAllByStatusAndShop(String status, ShopEntity shopEntity) {
        return this.orderRepository.findAllByStatusAndShop(status, shopEntity);
    }

    @Override
    public OrderEntity findOne(long id) {
        return this.orderRepository.findOne(id);
    }

    @Override
    public List<OrderEntity> findAllByShop(ShopEntity shopEntity) {
        return this.orderRepository.findAllByShop(shopEntity);
    }
}

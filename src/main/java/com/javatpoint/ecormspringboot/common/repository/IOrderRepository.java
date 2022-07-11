package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.OrderEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findAllByStatus(String status);

    List<OrderEntity> findAllByStatusAndShop(String status, ShopEntity shopEntity);

    List<OrderEntity> findAllByShop(ShopEntity shopEntity);

    List<OrderEntity> findAllByUser(UserEntity userEntity);
}

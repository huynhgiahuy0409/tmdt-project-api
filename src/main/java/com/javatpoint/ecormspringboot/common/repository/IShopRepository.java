package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IShopRepository extends JpaRepository<ShopEntity, Long> {
    List<ShopEntity> findByNameContaining(String name);
    ShopEntity findByProducts(List<ProductEntity> product);
}

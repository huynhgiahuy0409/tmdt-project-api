package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.buyer.products.model.Product;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IShopService {
    ShopEntity findOne(long id);

    List<ShopEntity> findByNameContaining(String name);

    ShopEntity findByProducts(List<ProductEntity> product);
}

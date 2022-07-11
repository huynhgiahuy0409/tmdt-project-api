package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.dto.ProductDTO;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IProductService {
    public List<ProductEntity> findAll(Pageable pageable);
    public List<ProductEntity> findAll();
    public List<ProductEntity> findAll(Specification<ProductEntity> specification, Pageable pageable);
    public ProductEntity save(ProductEntity productEntity);
    public ProductEntity findById(long id);
    public ProductEntity saveAndFlush(ProductEntity productEntity);
    List<ProductEntity> findByNameContaining(String searchValue, Pageable pageable);
    ProductEntity findOne(long id);
    ProductEntity findByShop(ShopEntity shop);
}

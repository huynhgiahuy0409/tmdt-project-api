package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.dto.ProductDTO;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    public List<ProductDTO> findAll(Pageable pageable);
    public ProductEntity save(ProductEntity productEntity);
}

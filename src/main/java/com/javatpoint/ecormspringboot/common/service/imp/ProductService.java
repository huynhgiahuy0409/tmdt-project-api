package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.dto.ProductDTO;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.repository.IProductRepository;
import com.javatpoint.ecormspringboot.common.service.IProductService;
import com.javatpoint.ecormspringboot.common.util.ConverterUtil;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ObjectMapperUtils mp;

    @Override
    public List<ProductEntity> findAll(Pageable pageable) {
        List<ProductEntity> productsEntity = this.productRepository.findAll(pageable).getContent();
        return productsEntity;
    }

    @Override
    public List<ProductEntity> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return this.productRepository.save(productEntity);
    }

    @Override
    public ProductEntity findById(long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public ProductEntity saveAndFlush(ProductEntity productEntity) {
        return this.productRepository.saveAndFlush(productEntity);
    }

    @Override
    public List<ProductEntity> findByNameContaining(String searchValue, Pageable pageable) {
        return this.productRepository.findByNameContaining(searchValue, pageable);
    }

    @Override
    public ProductEntity findOne(long id) {
        return this.productRepository.findOne(id);
    }

    @Override
    public List<ProductEntity> findAll(Specification<ProductEntity> specification, Pageable pageable) {
        return this.productRepository.findAll(specification, pageable).getContent();
    }


}

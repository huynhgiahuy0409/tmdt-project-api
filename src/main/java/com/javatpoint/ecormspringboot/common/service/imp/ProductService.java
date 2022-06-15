package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.dto.ProductDTO;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.repository.IProductRepository;
import com.javatpoint.ecormspringboot.common.service.IProductService;
import com.javatpoint.ecormspringboot.common.util.ConverterUtil;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ObjectMapperUtils mp;

    @Override
    public List<ProductDTO> findAll(Pageable pageable) {
        List<ProductEntity> productsEntity = this.productRepository.findAll(pageable).getContent();
        List<ProductDTO> result = this.mp.mapAll(productsEntity, ProductDTO.class);
        return result;
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return this.productRepository.save(productEntity);
    }


}

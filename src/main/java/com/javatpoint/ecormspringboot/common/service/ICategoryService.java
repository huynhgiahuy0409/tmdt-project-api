package com.javatpoint.ecormspringboot.common.service;

import java.util.List;

import com.javatpoint.ecormspringboot.common.dto.CategoryDTO;
import com.javatpoint.ecormspringboot.common.entity.CategoryEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
	public CategoryEntity save(CategoryDTO category);

	public List<CategoryEntity> findAll();

	public CategoryEntity findByCode(String code);

	public List<CategoryEntity> findAll(Pageable pageable);

	List<CategoryEntity> findByProducts(List<ProductEntity> products);
}

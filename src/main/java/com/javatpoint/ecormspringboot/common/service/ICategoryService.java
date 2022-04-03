package com.javatpoint.ecormspringboot.common.service;

import java.util.List;

import com.javatpoint.ecormspringboot.common.dto.CategoryDTO;
import com.javatpoint.ecormspringboot.common.entity.CategoryEntity;

public interface ICategoryService {
	public CategoryEntity save(CategoryDTO category);

	public List<CategoryEntity> findAll();
}

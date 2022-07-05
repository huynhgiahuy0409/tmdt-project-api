package com.javatpoint.ecormspringboot.common.service.imp;

import java.util.List;

import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javatpoint.ecormspringboot.common.dto.CategoryDTO;
import com.javatpoint.ecormspringboot.common.entity.CategoryEntity;
import com.javatpoint.ecormspringboot.common.repository.ICategoryRepository;
import com.javatpoint.ecormspringboot.common.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	ModelMapper mp;

	@Override
	public CategoryEntity save(CategoryDTO category) {
		// TODO Auto-generated method stub
		CategoryEntity result = this.categoryRepository.saveAndFlush(this.mp.map(category, CategoryEntity.class));
		return result;
	}

	@Override
	public List<CategoryEntity> findAll() {
		// TODO Auto-generated method stub
		return this.categoryRepository.findAll();
	}

	@Override
	public CategoryEntity findByCode(String code) {
		return this.categoryRepository.findByCode(code);
	}

	@Override
	public List<CategoryEntity> findAll(Pageable pageable) {
		return this.categoryRepository.findAll(pageable).getContent();
	}

	@Override
	public List<CategoryEntity> findByProducts(List<ProductEntity> products) {
		return this.categoryRepository.findByProducts(products);
	}
}

package com.javatpoint.ecormspringboot.common.helper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.javatpoint.ecormspringboot.common.dto.CategoryDTO;
import com.javatpoint.ecormspringboot.common.entity.CategoryEntity;
import com.javatpoint.ecormspringboot.common.service.ICategoryService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;

@Component(value = "CategoryHelper")
public class CategoryHelper {

	@Autowired
	private ICategoryService categorySerivce;
	@Autowired
	private ModelMapper mp;
	@Autowired
	private ObjectMapperUtils om;

	public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO reqCategory) {
		CategoryEntity categoryEntity = this.categorySerivce.save(reqCategory);
		return ResponseEntity.ok(this.mp.map(categoryEntity, CategoryDTO.class));
	}

	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryEntity> categories = this.categorySerivce.findAll();
		System.out.println(categories);
		List<CategoryDTO> result = this.om.mapAll(categories, CategoryDTO.class);
		return ResponseEntity.ok(result);
	}
}

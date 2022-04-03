package com.javatpoint.ecormspringboot.common.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.ecormspringboot.common.dto.CategoryDTO;
import com.javatpoint.ecormspringboot.common.entity.CategoryEntity;
import com.javatpoint.ecormspringboot.common.helper.CategoryHelper;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

	@Autowired
	CategoryHelper categoryHelper;

	@PostMapping(value = "/add")
	private ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO reqCategory) {
		return this.categoryHelper.addCategory(reqCategory);
	}

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		return this.categoryHelper.findAll();
	}
}

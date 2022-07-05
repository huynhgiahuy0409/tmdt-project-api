package com.javatpoint.ecormspringboot.common.api;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.service.ICategoryService;
import com.javatpoint.ecormspringboot.common.service.IShopService;
import com.javatpoint.ecormspringboot.common.service.imp.CategoryService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javatpoint.ecormspringboot.common.dto.CategoryDTO;
import com.javatpoint.ecormspringboot.common.entity.CategoryEntity;
import com.javatpoint.ecormspringboot.common.helper.CategoryHelper;

@RestController
@RequestMapping(value = "/api")
public class CategoryController {

	@Autowired
	CategoryHelper categoryHelper;

	@Autowired
	ICategoryService categoryService;

	@Autowired
	IShopService shopService;

	@Autowired
	ObjectMapperUtils om;
	@PostMapping(value = "/add")
	private ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO reqCategory) {
		return this.categoryHelper.addCategory(reqCategory);
	}

	@GetMapping("/category/all")
	public ResponseEntity<List<CategoryDTO>> findAll() {
		return this.categoryHelper.findAll();
	}

	@GetMapping("/category")
	public ResponseEntity<List<CategoryDTO>> findPagination(@RequestParam int pageIndex, @RequestParam int pageSize) {
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		List<CategoryEntity> categoriesEntity = this.categoryService.findAll(pageable);
		List<CategoryDTO> result = this.om.mapAll(categoriesEntity, CategoryDTO.class);
		return ResponseEntity.ok(result);
	}
	@GetMapping("/shop/{shopId}/category")
	public ResponseEntity<List<CategoryDTO>> findByShop(@PathVariable long shopId) {
		ShopEntity foundShop = this.shopService.findOne(shopId);
		Set<ProductEntity> productEntities = foundShop.getProducts();
		Set<CategoryEntity> categoryEntities = productEntities.stream().map(productEntity -> {
			return productEntity.getCategory();
		}).collect(Collectors.toSet());

		return ResponseEntity.ok(this.om.mapAll(categoryEntities, CategoryDTO.class));
	}
}

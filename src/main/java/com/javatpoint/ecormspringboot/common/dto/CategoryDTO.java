package com.javatpoint.ecormspringboot.common.dto;

import java.util.HashSet;
import java.util.Set;

import com.javatpoint.ecormspringboot.common.entity.ProductEntity;

public class CategoryDTO {
	private String name;
	private String code;
	private Set<ProductEntity> products = new HashSet<ProductEntity>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductEntity> products) {
		this.products = products;
	}

}

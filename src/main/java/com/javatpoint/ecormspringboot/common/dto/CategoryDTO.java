package com.javatpoint.ecormspringboot.common.dto;

import java.util.HashSet;
import java.util.Set;

import com.javatpoint.ecormspringboot.common.entity.ProductEntity;

public class CategoryDTO {
	private String name;
	private String code;

	public CategoryDTO(String name, String code) {
		this.name = name;
		this.code = code;
	}
	public CategoryDTO() {
	}

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
}

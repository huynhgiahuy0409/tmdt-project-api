package com.javatpoint.ecormspringboot.common.dto;

import java.util.HashSet;
import java.util.Set;

import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import lombok.Data;

@Data
public class CategoryDTO {
	private long id;
	private String name;
	private String code;
}

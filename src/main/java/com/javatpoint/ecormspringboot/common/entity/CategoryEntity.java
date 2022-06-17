package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
@Data
public class CategoryEntity extends BaseEntity {
	private String name;
	private String code;

	@OneToMany(mappedBy = "category")
	private Set<ProductEntity> products = new HashSet<ProductEntity>();




}

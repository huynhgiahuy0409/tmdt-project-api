package com.javatpoint.ecormspringboot.common.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "material")
public class MaterialEntity extends BaseEntity {
	private String name;
	private String code;

	@OneToMany(mappedBy = "material")
	private Set<ProductEntity> products;

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

package com.javatpoint.ecormspringboot.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "material")
public class MaterialEntity extends BaseEntity {
	private String name;
	private String code;

	@OneToOne(mappedBy = "material", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ProductEntity product;

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

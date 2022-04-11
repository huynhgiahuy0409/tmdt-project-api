package com.javatpoint.ecormspringboot.common.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class BrandEntity extends BaseEntity {
	private String name;
	private String code;
	private String status;

	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ProductEntity> producst;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<ProductEntity> getProducst() {
		return producst;
	}

	public void setProducst(Set<ProductEntity> producst) {
		this.producst = producst;
	}


}

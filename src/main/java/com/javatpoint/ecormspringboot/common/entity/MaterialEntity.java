package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "material")
@Data
public class MaterialEntity extends BaseEntity {
	private String name;
	private String code;

	@OneToMany(mappedBy = "material")
	private Set<ProductEntity> products;


}

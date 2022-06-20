package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "material")
@Getter
@Setter
public class MaterialEntity extends BaseEntity {
	private String name;
	private String code;

	@OneToMany(mappedBy = "material")
	private Set<ProductEntity> products;


}

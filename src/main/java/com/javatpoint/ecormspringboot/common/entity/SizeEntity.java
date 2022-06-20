package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "size")
@Getter
@Setter
public class SizeEntity extends BaseEntity {
	private double weight;
	private double length;
	private double width;
	private double height;

	@OneToOne(mappedBy = "size", cascade = CascadeType.ALL)
	private ProductEntity product;


}

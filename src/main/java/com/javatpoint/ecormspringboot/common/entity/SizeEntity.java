package com.javatpoint.ecormspringboot.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "size")
public class SizeEntity extends BaseEntity {
	private double length;
	private double width;
	private double height;

	@OneToOne(mappedBy = "size", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ProductEntity product;

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}

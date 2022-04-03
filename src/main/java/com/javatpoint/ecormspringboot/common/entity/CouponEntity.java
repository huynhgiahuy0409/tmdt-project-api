package com.javatpoint.ecormspringboot.common.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
public class CouponEntity extends BaseEntity {
	private String name;
	private String code;
	private double value;

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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}

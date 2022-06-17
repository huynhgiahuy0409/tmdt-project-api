package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
@Data
public class CouponEntity extends BaseEntity {
	private String name;
	private String code;
	private double value;

}

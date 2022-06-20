package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "coupon")
@Getter
@Setter
public class CouponEntity extends BaseEntity {
	private String name;
	private String code;
	private double value;

}

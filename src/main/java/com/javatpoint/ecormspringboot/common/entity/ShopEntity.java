package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
@Getter
@Setter
public class ShopEntity extends BaseEntity {
	private String name;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "image_id")
	private ImageEntity avatar;
	private int numberReview;
	private int numberProduct;
	private int responseRate;
	private int responseTime;
	private int lastAccess;
	private int followers;


}

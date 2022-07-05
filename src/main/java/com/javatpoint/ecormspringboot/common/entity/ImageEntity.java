package com.javatpoint.ecormspringboot.common.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
@Getter
@Setter
public class ImageEntity extends BaseEntity {
	private String url;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	@OneToOne(mappedBy = "avatar")
	private ShopEntity shop;

	@OneToOne
	@JoinColumn(name = "brand_id")
	private BrandEntity brand;

	@OneToOne(mappedBy = "avatar")
	private UserEntity user;

}

package com.javatpoint.ecormspringboot.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class ImageEntity extends BaseEntity {
	private String url;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	@OneToOne(mappedBy = "avatar")
	private ShopEntity shop;

	@OneToOne
	@JoinColumn(name = "brand_id")
	private BrandEntity brand;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public ShopEntity getShop() {
		return shop;
	}

	public void setShop(ShopEntity shop) {
		this.shop = shop;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}


}

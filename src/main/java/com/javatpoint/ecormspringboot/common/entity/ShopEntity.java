package com.javatpoint.ecormspringboot.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageEntity getAvatar() {
		return avatar;
	}

	public void setAvatar(ImageEntity avatar) {
		this.avatar = avatar;
	}

	public int getNumberReview() {
		return numberReview;
	}

	public void setNumberReview(int numberReview) {
		this.numberReview = numberReview;
	}

	public int getNumberProduct() {
		return numberProduct;
	}

	public void setNumberProduct(int numberProduct) {
		this.numberProduct = numberProduct;
	}

	public int getResponseRate() {
		return responseRate;
	}

	public void setResponseRate(int responseRate) {
		this.responseRate = responseRate;
	}

	public int getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(int responseTime) {
		this.responseTime = responseTime;
	}

	public int getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(int lastAccess) {
		this.lastAccess = lastAccess;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

}

package com.javatpoint.ecormspringboot.common.entity;

public class RecommendAgeEntity extends BaseEntity {
	private String range;

	private String code;

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

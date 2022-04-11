package com.javatpoint.ecormspringboot.common.dto;

public class BrandDTO {
	private String name;
	private String code;
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BrandDTO [name=" + name + ", code=" + code + ", status=" + status + "]";
	}

}

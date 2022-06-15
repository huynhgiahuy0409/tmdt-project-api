package com.javatpoint.ecormspringboot.common.dto;

public class MaterialDTO {
	private String name;
	private String code;

	public MaterialDTO(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public MaterialDTO() {
	}
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

}

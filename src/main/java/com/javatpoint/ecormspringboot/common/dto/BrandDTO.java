package com.javatpoint.ecormspringboot.common.dto;

import lombok.Data;

@Data
public class BrandDTO {
	private String id;
	private String name;
	private String code;
	private String status;
	private BrandDTO logo;
}

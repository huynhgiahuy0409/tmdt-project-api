package com.javatpoint.ecormspringboot.common.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RecommendAgeDTO {
	private String name;
	private String code;
}

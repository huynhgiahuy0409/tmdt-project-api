package com.javatpoint.ecormspringboot.common.helper;

import com.javatpoint.ecormspringboot.common.entity.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.javatpoint.ecormspringboot.common.dto.BrandDTO;
import com.javatpoint.ecormspringboot.common.service.IBrandService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;

@Component(value = "BrandHelper")
public class BrandHelper {

	@Autowired
	private IBrandService brandService;

	@Autowired
	private ObjectMapperUtils om;

	public ResponseEntity<BrandDTO> addBrand(@RequestBody BrandDTO aBrand) {
		BrandEntity brandE = this.brandService.addBrand(aBrand);
		return ResponseEntity.ok(this.om.map(brandE, BrandDTO.class));
	}
}

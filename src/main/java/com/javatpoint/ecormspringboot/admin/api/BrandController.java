package com.javatpoint.ecormspringboot.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.ecormspringboot.common.dto.BrandDTO;
import com.javatpoint.ecormspringboot.common.helper.BrandHelper;

@RestController
@RequestMapping(value = "/api/admin/brand")
public class BrandController {

	@Autowired
	private BrandHelper brandHelper;

	@PostMapping(value = "/add")
	private ResponseEntity<BrandDTO> addBrand(@RequestBody BrandDTO aBrand) {
		System.out.println(aBrand);
		return this.brandHelper.addBrand(aBrand);
	}
}

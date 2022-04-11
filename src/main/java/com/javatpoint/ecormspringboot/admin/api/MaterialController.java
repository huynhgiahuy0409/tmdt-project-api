package com.javatpoint.ecormspringboot.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javatpoint.ecormspringboot.common.dto.MaterialDTO;
import com.javatpoint.ecormspringboot.common.helper.MaterialHelper;

@Controller
@RequestMapping(value = "/api/admin/material")
public class MaterialController {

	@Autowired
	private MaterialHelper materialHelper;

	@PostMapping
	public ResponseEntity<MaterialDTO> addMaterial(@RequestBody MaterialDTO material) {
		return this.materialHelper.addMaterial(material);
	}
}

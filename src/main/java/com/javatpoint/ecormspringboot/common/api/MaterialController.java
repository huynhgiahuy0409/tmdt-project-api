package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.MaterialDTO;
import com.javatpoint.ecormspringboot.common.helper.MaterialHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api/material")
public class MaterialController {

	@Autowired
	private MaterialHelper materialHelper;

	@PostMapping
	public ResponseEntity<MaterialDTO> addMaterial(@RequestBody MaterialDTO material) {
		return this.materialHelper.addMaterial(material);
	}
	@GetMapping
	public ResponseEntity<List<MaterialDTO>> findAll() {
		return this.materialHelper.findAll();
	}
}

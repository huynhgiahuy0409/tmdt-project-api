package com.javatpoint.ecormspringboot.common.helper;

import javafx.scene.paint.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.javatpoint.ecormspringboot.common.dto.MaterialDTO;
import com.javatpoint.ecormspringboot.common.service.IMaterialService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;

import java.util.List;

@Component(value = "MaterialHelper")
public class MaterialHelper {

	@Autowired
	private IMaterialService materialService;

	@Autowired
	private ObjectMapperUtils om;

	public ResponseEntity<MaterialDTO> addMaterial(MaterialDTO material) {
		return ResponseEntity.ok(this.om.map(this.materialService.addMaterial(material), MaterialDTO.class));
	}
	public ResponseEntity<List<MaterialDTO>> findAll() {
		return ResponseEntity.ok(this.om.mapAll(this.materialService.findAll(), MaterialDTO.class));
	}
}

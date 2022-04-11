package com.javatpoint.ecormspringboot.common.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.ecormspringboot.common.dto.MaterialDTO;
import com.javatpoint.ecormspringboot.common.entity.MaterialEntity;
import com.javatpoint.ecormspringboot.common.repository.IMaterialRepository;
import com.javatpoint.ecormspringboot.common.service.IMaterialService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;

@Service
public class MaterialService implements IMaterialService {

	@Autowired
	private IMaterialRepository materialRepository;

	@Autowired
	private ObjectMapperUtils om;

	@Override
	public MaterialEntity addMaterial(MaterialDTO material) {
		// TODO Auto-generated method stub
		return this.materialRepository.saveAndFlush(this.om.map(material, MaterialEntity.class));
	}

}

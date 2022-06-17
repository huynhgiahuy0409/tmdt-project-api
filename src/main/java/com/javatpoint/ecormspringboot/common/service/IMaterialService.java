package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.dto.MaterialDTO;
import com.javatpoint.ecormspringboot.common.entity.MaterialEntity;

import java.util.List;

public interface IMaterialService {
	public MaterialEntity addMaterial(MaterialDTO material);
	public MaterialEntity findByCode(String code);
	public List<MaterialEntity> findAll();
}

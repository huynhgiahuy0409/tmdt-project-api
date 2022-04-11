package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.dto.MaterialDTO;
import com.javatpoint.ecormspringboot.common.entity.MaterialEntity;

public interface IMaterialService {
	public MaterialEntity addMaterial(MaterialDTO material);
}

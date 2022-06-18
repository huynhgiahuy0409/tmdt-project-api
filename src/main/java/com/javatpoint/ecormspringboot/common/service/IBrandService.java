package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.dto.BrandDTO;
import com.javatpoint.ecormspringboot.common.entity.BrandEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBrandService{
	public BrandEntity addBrand(BrandDTO aBrand);
	public BrandEntity findByCode(String code);
	public List<BrandEntity> findAll();
	public List<BrandEntity> findAll(Pageable pageable);
}

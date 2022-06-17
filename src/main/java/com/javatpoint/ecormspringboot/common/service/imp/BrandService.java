package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.BrandEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.ecormspringboot.common.dto.BrandDTO;
import com.javatpoint.ecormspringboot.common.repository.IBrandRepository;
import com.javatpoint.ecormspringboot.common.service.IBrandService;

import java.util.List;

@Service
public class BrandService implements IBrandService {
	@Autowired
	private IBrandRepository brandRepository;
	@Autowired
	private ModelMapper mp;
	@Override
	public BrandEntity addBrand(BrandDTO aBrand) {
		// TODO Auto-generated method stub
		BrandEntity brandE = this.mp.map(aBrand, BrandEntity.class);
		return this.brandRepository.saveAndFlush(brandE);
	}

	@Override
	public BrandEntity findByCode(String code) {
		return this.brandRepository.findByCode(code);
	}

	@Override
	public List<BrandEntity> findAll() {
		return this.brandRepository.findAll();
	}

}

package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.RecommendAgeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.ecormspringboot.common.dto.RecommendAgeDTO;
import com.javatpoint.ecormspringboot.common.repository.IRecommendAgeRepository;
import com.javatpoint.ecormspringboot.common.service.IRecommendAgeService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;

import java.util.List;

@Service
public class RecommendAgeService implements IRecommendAgeService {

	@Autowired
	private IRecommendAgeRepository recommendAgeRepository;
	@Autowired
	private ObjectMapperUtils om;

	@Override
	public RecommendAgeEntity add(RecommendAgeDTO aRecommendAge) {
		// TODO Auto-generated method stub
		return this.recommendAgeRepository.saveAndFlush(this.om.map(aRecommendAge, RecommendAgeEntity.class));
	}

	@Override
	public RecommendAgeEntity findByCode(String code) {
		return this.recommendAgeRepository.findByCode(code);
	}

	@Override
	public List<RecommendAgeEntity> findAll() {
		return this.recommendAgeRepository.findAll();
	}

}

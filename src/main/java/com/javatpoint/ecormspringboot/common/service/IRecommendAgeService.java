package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.dto.RecommendAgeDTO;
import com.javatpoint.ecormspringboot.common.entity.RecommendAgeEntity;

import java.util.List;

public interface IRecommendAgeService {
	public RecommendAgeEntity add(RecommendAgeDTO aRecommendAge);
	public RecommendAgeEntity findByCode(String code);
	public List<RecommendAgeEntity> findAll();
}

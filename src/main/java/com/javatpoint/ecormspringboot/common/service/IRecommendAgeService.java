package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.dto.RecommendAgeDTO;
import com.javatpoint.ecormspringboot.common.entity.RecommendAgeEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IRecommendAgeService {
	public RecommendAgeEntity add(RecommendAgeDTO aRecommendAge);
	public RecommendAgeEntity findByCode(String code);
	public List<RecommendAgeEntity> findAll();
	public List<RecommendAgeEntity> findAll(Pageable pageable);
}

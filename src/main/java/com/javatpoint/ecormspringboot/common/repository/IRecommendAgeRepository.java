package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.RecommendAgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecommendAgeRepository extends JpaRepository<RecommendAgeEntity, Long> {
    RecommendAgeEntity findByCode(String code);
}

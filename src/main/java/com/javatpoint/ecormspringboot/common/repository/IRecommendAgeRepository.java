package com.javatpoint.ecormspringboot.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.ecormspringboot.common.entity.RecommendAgeEntity;

public interface IRecommendAgeRepository extends JpaRepository<RecommendAgeEntity, Long> {

}

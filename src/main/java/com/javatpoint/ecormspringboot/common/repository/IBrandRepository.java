package com.javatpoint.ecormspringboot.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.ecormspringboot.common.entity.BrandEntity;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
	
}

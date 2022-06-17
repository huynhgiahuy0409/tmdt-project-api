package com.javatpoint.ecormspringboot.common.helper;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.javatpoint.ecormspringboot.common.dto.RecommendAgeDTO;
import com.javatpoint.ecormspringboot.common.service.IRecommendAgeService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;

import java.util.List;

@Component(value = "RecommendAgeHelper")
public class RecommendAgeHelper {

	@Autowired
	private IRecommendAgeService recommendAgeService;

	@Autowired
	private ObjectMapperUtils om;

	public ResponseEntity<RecommendAgeDTO> addRecommendAge(RecommendAgeDTO aRecommendAge) {
		return ResponseEntity.ok(this.om.map(this.recommendAgeService.add(aRecommendAge), RecommendAgeDTO.class));
	}
	public  ResponseEntity<List<RecommendAgeDTO>> findAll(){
		return ResponseEntity.ok(this.om.mapAll(this.recommendAgeService.findAll(), RecommendAgeDTO.class));
	}
}

package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.CategoryDTO;
import com.javatpoint.ecormspringboot.common.dto.RecommendAgeDTO;
import com.javatpoint.ecormspringboot.common.entity.CategoryEntity;
import com.javatpoint.ecormspringboot.common.entity.RecommendAgeEntity;
import com.javatpoint.ecormspringboot.common.helper.RecommendAgeHelper;
import com.javatpoint.ecormspringboot.common.service.imp.RecommendAgeService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/api/recommend-age")
public class RecommendAgeController {

	@Autowired
	private RecommendAgeHelper recommendAgeHelper;

	@Autowired
	private RecommendAgeService recommendAgeService;

	@Autowired
	private ObjectMapperUtils om;
	public ResponseEntity<RecommendAgeDTO> addRecommendAge(@RequestBody RecommendAgeDTO aRecommendAge) {
		return this.recommendAgeHelper.addRecommendAge(aRecommendAge);
	}
	@GetMapping("/all")
	public ResponseEntity<List<RecommendAgeDTO>> findAll(){
		return this.recommendAgeHelper.findAll();
	}

	@GetMapping
	public ResponseEntity<List<RecommendAgeDTO>> findPagination(@RequestParam int pageIndex, @RequestParam int pageSize) {
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		List<RecommendAgeEntity> recommendAgeEntities = this.recommendAgeService.findAll(pageable);
		List<RecommendAgeDTO> result = this.om.mapAll(recommendAgeEntities, RecommendAgeDTO.class);
		return ResponseEntity.ok(result);
	}
}

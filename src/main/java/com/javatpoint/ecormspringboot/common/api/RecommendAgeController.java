package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.RecommendAgeDTO;
import com.javatpoint.ecormspringboot.common.helper.RecommendAgeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api/recommend-age")
public class RecommendAgeController {

	@Autowired
	private RecommendAgeHelper recommendAgeHelper;

	public ResponseEntity<RecommendAgeDTO> addRecommendAge(@RequestBody RecommendAgeDTO aRecommendAge) {
		return this.recommendAgeHelper.addRecommendAge(aRecommendAge);
	}
	@GetMapping
	public ResponseEntity<List<RecommendAgeDTO>> findAll(){
		return this.recommendAgeHelper.findAll();
	}
}

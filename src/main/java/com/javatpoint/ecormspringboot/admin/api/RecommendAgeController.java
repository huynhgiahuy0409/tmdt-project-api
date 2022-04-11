package com.javatpoint.ecormspringboot.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javatpoint.ecormspringboot.common.dto.RecommendAgeDTO;
import com.javatpoint.ecormspringboot.common.helper.RecommendAgeHelper;

@Controller
@RequestMapping(value = "/api/admin/recommend-age")
public class RecommendAgeController {

	@Autowired
	private RecommendAgeHelper recommendAgeHelper;

	public ResponseEntity<RecommendAgeDTO> addRecommendAge(@RequestBody RecommendAgeDTO aRecommendAge) {
		return this.recommendAgeHelper.addRecommendAge(aRecommendAge);
	}
}

package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.OriginDTO;
import com.javatpoint.ecormspringboot.common.service.IOriginService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/origin")
public class OriginController {
    @Autowired
    ObjectMapperUtils om;
    @Autowired
    IOriginService originService;
    @GetMapping
    public ResponseEntity<List<OriginDTO>> findAll(){
       return ResponseEntity.ok(this.om.mapAll(this.originService.findAll(), OriginDTO.class));
    }
}

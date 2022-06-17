package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.OriginDTO;
import com.javatpoint.ecormspringboot.common.dto.StatusDTO;
import com.javatpoint.ecormspringboot.common.service.IOriginService;
import com.javatpoint.ecormspringboot.common.service.IStatusService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api/status")
public class StatusController {
    @Autowired
    ObjectMapperUtils om;
    @Autowired
    IStatusService statusService;
    @GetMapping
    public ResponseEntity<List<StatusDTO>> findAll(){
        return ResponseEntity.ok(this.om.mapAll(this.statusService.findAll(), StatusDTO.class));
    }
}

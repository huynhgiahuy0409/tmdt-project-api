package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.BrandDTO;
import com.javatpoint.ecormspringboot.common.dto.CategoryDTO;
import com.javatpoint.ecormspringboot.common.helper.CategoryHelper;
import com.javatpoint.ecormspringboot.common.service.IBrandService;
import com.javatpoint.ecormspringboot.common.service.imp.BrandService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/brand")
public class BrandController {
    @Autowired
    IBrandService brandService;
    @Autowired
    private ObjectMapperUtils mp;
//    @PostMapping(value = "/add")
//    private ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO reqCategory) {
//        return this.categoryHelper.addCategory(reqCategory);
//    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> findAll() {
        return ResponseEntity.ok(this.mp.mapAll(this.brandService.findAll(),BrandDTO.class));
    }
}

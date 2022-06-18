package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.BrandDTO;
import com.javatpoint.ecormspringboot.common.dto.CategoryDTO;
import com.javatpoint.ecormspringboot.common.entity.BrandEntity;
import com.javatpoint.ecormspringboot.common.entity.CategoryEntity;
import com.javatpoint.ecormspringboot.common.service.IBrandService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/brand")
public class BrandController {
    @Autowired
    IBrandService brandService;
    @Autowired
    private ObjectMapperUtils om;
//    @PostMapping(value = "/add")
//    private ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO reqCategory) {
//        return this.categoryHelper.addCategory(reqCategory);
//    }

    @GetMapping("/all")
    public ResponseEntity<List<BrandDTO>> findAll() {
        return ResponseEntity.ok(this.om.mapAll(this.brandService.findAll(),BrandDTO.class));
    }
    @GetMapping
    public ResponseEntity<List<BrandDTO>> findPagination(@RequestParam int pageIndex, @RequestParam int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        List<BrandEntity> brandEntity = this.brandService.findAll(pageable);
        List<BrandDTO> result = this.om.mapAll(brandEntity, BrandDTO.class);
        return ResponseEntity.ok(result);
    }
}

package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.DistrictDTO;
import com.javatpoint.ecormspringboot.common.dto.ProvinceDTO;
import com.javatpoint.ecormspringboot.common.dto.WardDTO;
import com.javatpoint.ecormspringboot.common.entity.DistrictEntity;
import com.javatpoint.ecormspringboot.common.entity.ProvinceEntity;
import com.javatpoint.ecormspringboot.common.entity.WardEntity;
import com.javatpoint.ecormspringboot.common.service.IDistrictService;
import com.javatpoint.ecormspringboot.common.service.IProvinceService;
import com.javatpoint.ecormspringboot.common.service.IWardService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/address")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private IWardService wardService;

    @Autowired
    private ObjectMapperUtils om;


    @GetMapping("/province/all")
    public ResponseEntity<List<ProvinceDTO>> findAllProvince(){
        List<ProvinceEntity> provinceEntities = this.provinceService.findAll();
        List<ProvinceDTO> provinceDTOS = this.om.mapAll(provinceEntities, ProvinceDTO.class);
        return ResponseEntity.ok(provinceDTOS);
    }

    @GetMapping("/district/all")
    public ResponseEntity<List<DistrictDTO>> findAllDistrict(){
        List<DistrictEntity> provinceEntities = this.districtService.findAll();
        List<DistrictDTO> provinceDTOS = this.om.mapAll(provinceEntities, DistrictDTO.class);
        return ResponseEntity.ok(provinceDTOS);
    }

    @GetMapping("/district/allByProvince")
    public ResponseEntity<List<DistrictDTO>> findAllDistrictBYProvince(@RequestParam long provinceId){
        List<DistrictEntity> districtEntities = this.districtService.findAllByProvinceId(provinceId);
        List<DistrictDTO> districtDTOS = this.om.mapAll(districtEntities, DistrictDTO.class);
        return ResponseEntity.ok(districtDTOS);
    }
    @GetMapping("/district/allByProvinceDistrict")
    public ResponseEntity<List<WardDTO>> findAllDistrictBYProvinceDistrict(@RequestParam long provinceId,@RequestParam long districtId){
        List<WardEntity> wardEntities = this.wardService.findAllByProvinceIdAndDistrictId(provinceId,districtId);
        List<WardDTO> wardDTOS = this.om.mapAll(wardEntities, WardDTO.class);
        return ResponseEntity.ok(wardDTOS);
    }
}

package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.AddressDTO;
import com.javatpoint.ecormspringboot.common.dto.DistrictDTO;
import com.javatpoint.ecormspringboot.common.dto.ProvinceDTO;
import com.javatpoint.ecormspringboot.common.dto.WardDTO;
import com.javatpoint.ecormspringboot.common.entity.*;
import com.javatpoint.ecormspringboot.common.request.AddressRequest;
import com.javatpoint.ecormspringboot.common.service.*;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/address")
@CrossOrigin(origins = "http://localhost:4200")
@Transactional
public class AddressController {

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private IDistrictService districtService;

    @Autowired
    private IWardService wardService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private ObjectMapperUtils om;

    @Autowired
    private ModelMapper mp;

    @GetMapping("/province/all")
    public ResponseEntity<List<ProvinceDTO>> findAllProvince() {
        List<ProvinceEntity> provinceEntities = this.provinceService.findAll();
        List<ProvinceDTO> provinceDTOS = this.om.mapAll(provinceEntities, ProvinceDTO.class);
        return ResponseEntity.ok(provinceDTOS);
    }

    @GetMapping("/district/all")
    public ResponseEntity<List<DistrictDTO>> findAllDistrict() {
        List<DistrictEntity> provinceEntities = this.districtService.findAll();
        List<DistrictDTO> provinceDTOS = this.om.mapAll(provinceEntities, DistrictDTO.class);
        return ResponseEntity.ok(provinceDTOS);
    }

    @GetMapping("/district/allByProvince")
    public ResponseEntity<List<DistrictDTO>> findAllDistrictBYProvince(@RequestParam long provinceId) {
        List<DistrictEntity> districtEntities = this.districtService.findAllByProvinceId(provinceId);
        List<DistrictDTO> districtDTOS = this.om.mapAll(districtEntities, DistrictDTO.class);
        return ResponseEntity.ok(districtDTOS);
    }

    @GetMapping("/ward/allByProvinceDistrict")
    public ResponseEntity<List<WardDTO>> findAllDistrictBYProvinceDistrict(@RequestParam long provinceId, @RequestParam long districtId) {
        List<WardEntity> wardEntities = this.wardService.findAllByProvinceIdAndDistrictId(provinceId, districtId);
        List<WardDTO> wardDTOS = this.om.mapAll(wardEntities, WardDTO.class);
        return ResponseEntity.ok(wardDTOS);
    }

    @PostMapping("/add")
    public ResponseEntity<AddressDTO> addAddressForUser(@RequestBody AddressRequest addressRequest, @RequestParam long userId) {
        this.mp.getConfiguration().setPreferNestedProperties(false);
        this.mp.getConfiguration().setFieldMatchingEnabled(true);
        this.mp.getConfiguration().setAmbiguityIgnored(true);
        UserEntity userEntity = this.userService.findById(userId);
        Set<AddressEntity> userAddresses = userEntity.getAddresses();
        WardEntity wardEntity = this.wardService.findOne(addressRequest.getWardId());
        DistrictEntity districtEntity = this.districtService.findOne(addressRequest.getDistrictId());
        ProvinceEntity provinceEntity = this.provinceService.findOne(addressRequest.getProvinceId());
        AddressEntity requestAddressEntity = this.mp.map(addressRequest, AddressEntity.class);
        requestAddressEntity.setWard(wardEntity);
        requestAddressEntity.setDistrict(districtEntity);
        requestAddressEntity.setProvince(provinceEntity);
        requestAddressEntity.setUser(userEntity);
        if (addressRequest.getStatus() == 1) {
            userAddresses.stream().forEach(addressEntity -> {
                if (addressEntity.getStatus() == 1) {
                    addressEntity.setStatus(0);
                }
            });
        }
        AddressEntity savedAddressEntity = this.addressService.save(requestAddressEntity);
        userEntity.getAddresses().add(savedAddressEntity);
        return ResponseEntity.ok(this.mp.map(savedAddressEntity, AddressDTO.class));
    }

    @PutMapping("/update")
    public ResponseEntity updateAddressByUser(@RequestBody AddressDTO addressDTO, @RequestParam long userId) {
        try {
            this.mp.getConfiguration().setPreferNestedProperties(false);
            this.mp.getConfiguration().setSkipNullEnabled(true);
            AddressEntity addressRequestEntity = this.mp.map(addressDTO, AddressEntity.class);
            AddressEntity findAddressEntity = this.addressService.findOne(addressRequestEntity.getId());
            UserEntity userEntity = this.userService.findById(userId);
            Set<AddressEntity> userAddresses = userEntity.getAddresses();
            if (userAddresses.contains(findAddressEntity)) {
                WardEntity wardEntity = this.wardService.findOne(addressDTO.getWard().getId());
                DistrictEntity districtEntity = this.districtService.findOne(addressDTO.getDistrict().getId());
                ProvinceEntity provinceEntity = this.provinceService.findOne(addressDTO.getProvince().getId());
                this.mp.map(addressRequestEntity, findAddressEntity);
                findAddressEntity.setWard(wardEntity);
                findAddressEntity.setDistrict(districtEntity);
                findAddressEntity.setProvince(provinceEntity);
                if (addressDTO.getStatus() == 1) {
                    userAddresses.stream().forEach(addressEntity -> {
                        if (addressEntity.getStatus() == 1 && addressEntity.getId() != addressDTO.getId()) {
                            addressEntity.setStatus(0);
                        }
                    });
                }
                return ResponseEntity.ok(this.mp.map(findAddressEntity, AddressDTO.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

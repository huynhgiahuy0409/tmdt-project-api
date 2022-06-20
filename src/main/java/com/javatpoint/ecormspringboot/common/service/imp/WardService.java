package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.WardEntity;
import com.javatpoint.ecormspringboot.common.repository.IWardRepository;
import com.javatpoint.ecormspringboot.common.service.IWardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService implements IWardService {
    @Autowired
    private IWardRepository wardRepository;


    @Override
    public List<WardEntity> findAllByProvinceIdAndDistrictId(Long provinceId, Long districtId) {
        return this.wardRepository.findAllByProvinceIdAndDistrictId(provinceId, districtId);
    }
}

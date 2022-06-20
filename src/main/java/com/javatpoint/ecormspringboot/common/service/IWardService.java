package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.WardEntity;
import com.javatpoint.ecormspringboot.common.repository.IWardRepository;

import java.util.List;

public interface IWardService{
    List<WardEntity> findAllByProvinceIdAndDistrictId(Long provinceId, Long districtId);
}

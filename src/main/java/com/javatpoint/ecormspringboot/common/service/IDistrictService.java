package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.DistrictEntity;

import java.util.List;

public interface IDistrictService {
    public List<DistrictEntity> findAll();
    public List<DistrictEntity> findAllByProvinceId(long id);
}

package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.WardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWardRepository extends JpaRepository<WardEntity, Long> {
    public List<WardEntity> findAllByProvinceIdAndDistrictId(Long provinceId, Long districtId);
}

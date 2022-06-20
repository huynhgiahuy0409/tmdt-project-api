package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDistrictRepository extends JpaRepository<DistrictEntity, Long> {
    List<DistrictEntity> findAllByProvinceId(long id);
}

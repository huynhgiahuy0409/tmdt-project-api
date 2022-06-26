package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.DistrictEntity;
import com.javatpoint.ecormspringboot.common.repository.IDistrictRepository;
import com.javatpoint.ecormspringboot.common.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictService implements IDistrictService {
    @Autowired
    private IDistrictRepository districtRepository;
    @Override
    public List<DistrictEntity> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public List<DistrictEntity> findAllByProvinceId(long id) {
        return this.districtRepository.findAllByProvinceId(id);
    }

    @Override
    public DistrictEntity findOne(long id) {
        return this.districtRepository.findOne(id);
    }
}

package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.ProvinceEntity;
import com.javatpoint.ecormspringboot.common.repository.IProvinceRepository;
import com.javatpoint.ecormspringboot.common.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements IProvinceService {

    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public List<ProvinceEntity> findAll(){
        return this.provinceRepository.findAll();
    }

    @Override
    public ProvinceEntity findOne(long id) {
        return this.provinceRepository.findOne(id);
    }
}

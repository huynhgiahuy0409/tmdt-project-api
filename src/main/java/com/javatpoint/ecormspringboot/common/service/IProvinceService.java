package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.ProvinceEntity;
import com.javatpoint.ecormspringboot.common.repository.IProductRepository;

import java.util.List;

public interface IProvinceService{
    List<ProvinceEntity> findAll();
    ProvinceEntity findOne(long id);
}

package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.dto.StatusDTO;
import com.javatpoint.ecormspringboot.common.entity.StatusEntity;

import java.util.List;

public interface IStatusService {
    StatusEntity findByCode(String code);
    List<StatusEntity> findAll();
    StatusEntity save(StatusEntity statusEntity);
}

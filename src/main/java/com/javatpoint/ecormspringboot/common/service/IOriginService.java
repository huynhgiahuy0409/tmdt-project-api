package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.dto.OriginDTO;
import com.javatpoint.ecormspringboot.common.entity.OriginEntity;

import java.util.List;

public interface IOriginService {
    List<OriginEntity> findAll();
}

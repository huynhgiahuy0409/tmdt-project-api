package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.SizeEntity;
import com.javatpoint.ecormspringboot.common.repository.ISizeRepository;

public interface ISizeService{
    SizeEntity save(SizeEntity sizeEntity);
    SizeEntity saveAndFlush(SizeEntity sizeEntity);
}

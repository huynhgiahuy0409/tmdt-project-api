package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.SizeEntity;
import com.javatpoint.ecormspringboot.common.repository.ISizeRepository;
import com.javatpoint.ecormspringboot.common.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeService implements ISizeService {
    @Autowired
    ISizeRepository sizeRepository;
    @Override
    public SizeEntity save(SizeEntity sizeEntity) {
        return this.sizeRepository.save(sizeEntity);
    }

    @Override
    public SizeEntity saveAndFlush(SizeEntity sizeEntity) {
        return this.sizeRepository.saveAndFlush(sizeEntity);
    }
}

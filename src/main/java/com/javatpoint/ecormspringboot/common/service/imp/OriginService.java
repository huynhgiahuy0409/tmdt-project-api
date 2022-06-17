package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.dto.OriginDTO;
import com.javatpoint.ecormspringboot.common.entity.OriginEntity;
import com.javatpoint.ecormspringboot.common.repository.IOriginRepository;
import com.javatpoint.ecormspringboot.common.service.IOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OriginService implements IOriginService {
    @Autowired
    IOriginRepository originRepository;

    @Override
    public List<OriginEntity> findAll() {
        return this.originRepository.findAll();
    }
}

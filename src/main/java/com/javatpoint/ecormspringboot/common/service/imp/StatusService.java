package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.dto.StatusDTO;
import com.javatpoint.ecormspringboot.common.entity.StatusEntity;
import com.javatpoint.ecormspringboot.common.repository.IStatusRepository;
import com.javatpoint.ecormspringboot.common.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements IStatusService {
    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public StatusEntity findByCode(String code) {
        return this.statusRepository.findByCode(code);
    }

    @Override
    public List<StatusEntity> findAll() {
        return this.statusRepository.findAll();
    }

    @Override
    public StatusEntity save(StatusEntity statusEntity) {
        return this.statusRepository.save(statusEntity);
    }


}

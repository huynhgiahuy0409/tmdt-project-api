package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.StatusEntity;
import com.javatpoint.ecormspringboot.common.repository.IStatusRepository;
import com.javatpoint.ecormspringboot.common.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IStatusService {
    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public StatusEntity findByCode(String code) {
        return this.statusRepository.findByCode(code);
    }
}

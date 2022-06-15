package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.StatusEntity;

public interface IStatusService {
    StatusEntity findByCode(String code);
}

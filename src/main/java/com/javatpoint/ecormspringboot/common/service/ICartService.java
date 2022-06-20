package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.repository.ICartRepository;

public interface ICartService extends ICartRepository {
    CartEntity findById(long id);
}

package com.javatpoint.ecormspringboot.common.service.imp;


import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.repository.IShopRepository;
import com.javatpoint.ecormspringboot.common.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService implements IShopService {

    @Autowired
    private IShopRepository shopRepository;

    @Override
    public ShopEntity findOne(long id) {
        return this.shopRepository.findOne(id);
    }

    @Override
    public List<ShopEntity> findByNameContaining(String name) {
        return this.shopRepository.findByNameContaining(name);
    }
}

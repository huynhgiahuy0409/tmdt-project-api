package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.AddressEntity;
import com.javatpoint.ecormspringboot.common.repository.IAddressRepository;
import com.javatpoint.ecormspringboot.common.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Address;

@Service
public class AddressService implements IAddressService {
    @Autowired
    private IAddressRepository addressRepository;

    @Override
    public AddressEntity findOne(long id) {
        return this.addressRepository.findOne(id);
    }

    @Override
    public AddressEntity save(AddressEntity address) {
        return this.addressRepository.save(address);
    }

}

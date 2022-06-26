package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.AddressEntity;

import javax.mail.Address;

public interface IAddressService {
    public AddressEntity findOne(long id);
    public AddressEntity save(AddressEntity address);
}

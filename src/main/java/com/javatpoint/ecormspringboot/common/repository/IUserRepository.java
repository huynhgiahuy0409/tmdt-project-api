package com.javatpoint.ecormspringboot.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.ecormspringboot.common.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}

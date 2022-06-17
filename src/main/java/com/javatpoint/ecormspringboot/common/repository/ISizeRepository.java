package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISizeRepository extends JpaRepository<SizeEntity, Long> {

}

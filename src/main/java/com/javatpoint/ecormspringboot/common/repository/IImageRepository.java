package com.javatpoint.ecormspringboot.common.repository;

import com.javatpoint.ecormspringboot.common.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<ImageEntity, Long> {
}

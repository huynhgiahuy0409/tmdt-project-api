package com.javatpoint.ecormspringboot.common.service;

import com.javatpoint.ecormspringboot.common.entity.ImageEntity;

public interface IImageService {
    ImageEntity save(ImageEntity image);
}

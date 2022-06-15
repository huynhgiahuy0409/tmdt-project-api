package com.javatpoint.ecormspringboot.common.service.imp;

import com.javatpoint.ecormspringboot.common.entity.ImageEntity;
import com.javatpoint.ecormspringboot.common.repository.IImageRepository;
import com.javatpoint.ecormspringboot.common.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService implements IImageService {
    @Autowired
    private IImageRepository imageRepository;

    @Override
    public ImageEntity save(ImageEntity image) {
        return this.imageRepository.save(image);
    }
}

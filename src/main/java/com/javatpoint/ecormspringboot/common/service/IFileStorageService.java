package com.javatpoint.ecormspringboot.common.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IFileStorageService {
    List<String> storeFiles(MultipartFile[] files);
}

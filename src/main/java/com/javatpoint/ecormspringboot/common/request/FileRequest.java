package com.javatpoint.ecormspringboot.common.request;

import org.springframework.web.multipart.MultipartFile;

public class FileRequest {
    private MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}

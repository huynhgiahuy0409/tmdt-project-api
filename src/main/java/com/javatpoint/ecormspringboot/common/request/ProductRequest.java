package com.javatpoint.ecormspringboot.common.request;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {
    private MultipartFile files;
    private String model;


    public MultipartFile getFiles() {
        return files;
    }

    public void setFiles(MultipartFile files) {
        this.files = files;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "files=" + files +
                ", model='" + model + '\'' +
                '}';
    }


}

package com.javatpoint.ecormspringboot.common.dto;

public class ImageDTO {
    private String url;

    public ImageDTO(String url) {
        this.url = url;
    }
    public ImageDTO() {
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

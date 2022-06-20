package com.javatpoint.ecormspringboot.common.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ProvinceDTO {
    private long id;

    private String name;

    private String code;
}

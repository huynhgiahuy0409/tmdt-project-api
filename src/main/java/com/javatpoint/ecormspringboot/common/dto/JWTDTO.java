package com.javatpoint.ecormspringboot.common.dto;

import lombok.Data;

import java.util.Date;
@Data
public class JWTDTO {
    String token;
    Date tokenExpirationDate;
}

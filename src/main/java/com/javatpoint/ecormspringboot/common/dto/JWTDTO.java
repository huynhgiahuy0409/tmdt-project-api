package com.javatpoint.ecormspringboot.common.dto;

import java.util.Date;

public class JWTDTO {
    String token;
    Date tokenExpirationDate;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(Date tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }
}

package com.javatpoint.ecormspringboot.response;

import com.javatpoint.ecormspringboot.common.dto.JWTDTO;
import com.javatpoint.ecormspringboot.common.dto.UserDTO;

public class AuthenticationResponse {
    UserDTO user;
    JWTDTO accessToken;
    JWTDTO refreshToken;

    public AuthenticationResponse(UserDTO user, JWTDTO accessToken, JWTDTO refreshToken) {
        this.user = user;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public JWTDTO getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(JWTDTO accessToken) {
        this.accessToken = accessToken;
    }

    public JWTDTO getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(JWTDTO refreshToken) {
        this.refreshToken = refreshToken;
    }
}

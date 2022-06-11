package com.javatpoint.ecormspringboot.common.request;

public class RegisterAccountRequest {
    private String username;
    private String password;
    private String fullName;

    public RegisterAccountRequest(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullName = fullname;
    }

    public RegisterAccountRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

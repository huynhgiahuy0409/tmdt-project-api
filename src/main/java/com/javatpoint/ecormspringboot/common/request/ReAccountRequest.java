package com.javatpoint.ecormspringboot.common.request;

public class ReAccountRequest {
    private String username;
    private String newPassword;

    public ReAccountRequest(String username, String rePassword) {
        this.username = username;
        this.newPassword = rePassword;
    }
    public ReAccountRequest() {
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}


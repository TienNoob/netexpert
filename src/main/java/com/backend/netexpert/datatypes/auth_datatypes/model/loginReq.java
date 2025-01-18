package com.backend.netexpert.datatypes.auth_datatypes.model;

public class loginReq {
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public loginReq(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

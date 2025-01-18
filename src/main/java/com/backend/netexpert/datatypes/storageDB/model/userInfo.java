package com.backend.netexpert.datatypes.storageDB.model;

public class userInfo{
    private int user_id;
    private String username;
    private String email;
    private String full_name;
    private String phone_number;
    private String address;

    public userInfo(int user_id, String username, String email, String full_name, String phone_number, String address) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.address = address;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    
    
}

package com.backend.netexpert.datatypes.storageDB.builder;

import com.backend.netexpert.datatypes.storageDB.builder_interface.userInfoInterface;
import com.backend.netexpert.datatypes.storageDB.model.userInfo;

public class userBuilder implements userInfoInterface{
    private int user_id;
    private String username;
    private String email;
    private String full_name;
    private String phone_number;
    private String address;

    @Override
    public userInfoInterface user_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    @Override
    public userInfoInterface usernamne(String user_name) {
        this.username = user_name;
        return this;
    }

    @Override
    public userInfoInterface email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public userInfoInterface full_name(String full_name) {
        this.full_name = full_name;
        return this;
    }

    @Override
    public userInfoInterface phone_name(String phone_number) {
        this.phone_number = phone_number;
        return this;
    }

    @Override
    public userInfoInterface address(String address) {
        this.address = address;
        return this;
    }

    @Override
    public userInfo build() {
        return new userInfo(user_id, username, email, full_name, phone_number, address);
    }

    
}

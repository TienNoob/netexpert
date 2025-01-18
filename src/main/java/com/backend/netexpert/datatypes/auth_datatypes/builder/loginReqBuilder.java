package com.backend.netexpert.datatypes.auth_datatypes.builder;

import com.backend.netexpert.datatypes.auth_datatypes.builder_interface.loginReqInterface;
import com.backend.netexpert.datatypes.auth_datatypes.model.loginReq;

public class loginReqBuilder implements loginReqInterface{

    String username;
    String password;
    @Override
    public loginReqInterface username(String username) {
        this.username = username;
        return this;
    }

    @Override
    public loginReqInterface password(String password) {
        this.password = password;
        return this;
    }

    @Override
    public loginReq build() {
        return new loginReq(username, password);
    }

}

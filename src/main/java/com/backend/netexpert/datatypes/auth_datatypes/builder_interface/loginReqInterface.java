package com.backend.netexpert.datatypes.auth_datatypes.builder_interface;

import com.backend.netexpert.datatypes.auth_datatypes.model.loginReq;

public interface loginReqInterface {
    loginReqInterface username (String username);
    loginReqInterface password (String password);

    loginReq build();
} 

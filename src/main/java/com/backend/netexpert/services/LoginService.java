package com.backend.netexpert.services;

import java.util.List;

import com.backend.netexpert.datatypes.auth_datatypes.model.loginReq;
import com.backend.netexpert.datatypes.storageDB.model.userInfo;

public interface LoginService {

    public List<userInfo> getEmail();

    boolean existAccount(loginReq LoginReq);
} 

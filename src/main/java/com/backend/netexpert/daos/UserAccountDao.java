package com.backend.netexpert.daos;

import java.util.List;

import com.backend.netexpert.datatypes.auth_datatypes.model.loginReq;
import com.backend.netexpert.datatypes.storageDB.model.userInfo;

public interface UserAccountDao {
    List<userInfo> getAllUsers();
    
    boolean existAccount(loginReq LoginReq);
}

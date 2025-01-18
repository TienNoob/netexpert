package com.backend.netexpert.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.netexpert.daos.UserAccountDao;
import com.backend.netexpert.datatypes.auth_datatypes.model.loginReq;
import com.backend.netexpert.datatypes.storageDB.model.userInfo;
import com.backend.netexpert.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

    private final UserAccountDao userAccountDao;
    public LoginServiceImpl(UserAccountDao userAccountDao) {
        this.userAccountDao = userAccountDao;
    }

    @Override
    public List<userInfo> getEmail()
    {
        return userAccountDao.getAllUsers();
    }

    @Override
    public boolean existAccount(loginReq LoginReq) {
        return userAccountDao.existAccount(LoginReq);
    }
}

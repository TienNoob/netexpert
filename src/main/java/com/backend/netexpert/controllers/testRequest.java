package com.backend.netexpert.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.netexpert.datatypes.auth_datatypes.model.loginReq;
import com.backend.netexpert.datatypes.storageDB.model.userInfo;
import com.backend.netexpert.services.LoginService;

@RequestMapping("test")
@RestController
@CrossOrigin
public class testRequest {

    private final LoginService loginService;
    public testRequest(LoginService loginService) {
        this.loginService = loginService;
    }
    @GetMapping("/get-email")
    public ResponseEntity< List<userInfo> > getEmail()
    {
        return new ResponseEntity<List<userInfo> > (loginService.getEmail(), HttpStatus.OK);
    }

    @GetMapping("/health")
    public int check()
    {
        return 1;
    }
    @GetMapping("/check-account")
    boolean check_exist_account(@RequestBody loginReq LoginReq)
    {
        return loginService.existAccount(LoginReq);
    }
}

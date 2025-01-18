package com.backend.netexpert.controllers;

import com.backend.netexpert.datatypes.auth_datatypes.model.forgotPassReq;
import com.backend.netexpert.datatypes.auth_datatypes.model.forgotPassRes;
import com.backend.netexpert.datatypes.auth_datatypes.model.loginReq;
import com.backend.netexpert.datatypes.auth_datatypes.model.loginRes;
import com.backend.netexpert.datatypes.auth_datatypes.model.registerReq;
import com.backend.netexpert.datatypes.auth_datatypes.model.registerRes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.netexpert.services.LoginService;
@RestController
@CrossOrigin
@RequestMapping("api/auth")
public class authController {

    private final LoginService loginService;

    authController(LoginService loginService)
    {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody loginReq login_info)
    {
        loginRes res = new loginRes();
        
        boolean existInDb = loginService.existAccount(login_info); // Add db here

        if (existInDb)
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
        }
        else 
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody registerReq resigter_info)
    {
        registerRes res = new registerRes();

        boolean validInfo = false;
        
        if (validInfo)
        {
            // Add db here
            res.message = "Đăng ký thành công";
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        }
        else 
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgot_password (@RequestBody forgotPassReq resigter_info)
    {
        forgotPassRes res = new forgotPassRes();

        boolean emailExistInDB = false;
        
        if (emailExistInDB)
        {
            res.message = "Vui lòng kiểm tra email để đặt lại mật khẩu.";
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        }
        else 
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}

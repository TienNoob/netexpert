package com.backend.netexpert.controllers;

import com.backend.netexpert.datatypes.auth_datatypes.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/auth")
public class authController {

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody login_req login_info)
    {
        login_res res = new login_res();
        
        boolean existInDb = true; // Add db here

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
    public ResponseEntity<?> register (@RequestBody register_req resigter_info)
    {
        register_res res = new register_res();

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
    public ResponseEntity<?> forgot_password (@RequestBody forgotPassword_req resigter_info)
    {
        forgotPassword_res res = new forgotPassword_res();

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

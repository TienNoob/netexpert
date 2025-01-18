package com.backend.netexpert.datatypes.storageDB.builder_interface;

import com.backend.netexpert.datatypes.storageDB.model.userInfo;

public interface userInfoInterface {
    
    userInfoInterface user_id(int user_id);
    userInfoInterface usernamne(String user_name);
    userInfoInterface email(String email);
    userInfoInterface full_name(String full_name);
    userInfoInterface phone_name(String phone_number);
    userInfoInterface address(String address);

    userInfo build();
}

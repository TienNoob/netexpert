package com.backend.netexpert.daos.impl;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.backend.netexpert.daos.UserAccountDao;
import com.backend.netexpert.datatypes.auth_datatypes.model.loginReq;
import com.backend.netexpert.datatypes.storageDB.builder.userBuilder;
import com.backend.netexpert.datatypes.storageDB.model.userInfo;

@Component
public class userAccountDaoImpl implements UserAccountDao{

    private final JdbcTemplate jdbcTemplate;

    public userAccountDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<userInfo> getAllUsers() {
        return jdbcTemplate.query("select email from testdb", (ResultSet rs, int rowNum) -> {

            return new userBuilder()
            .email(rs.getString("email"))
            .build();
            
            });
    }

    @Override
    public boolean existAccount(loginReq LoginReq) {
        String query = "SELECT EXISTS (" +
                       "SELECT 1 FROM testdb WHERE username = ? AND password = ?)";
        
        // Use jdbcTemplate.queryForObject to execute the query and return a boolean
        boolean ret = jdbcTemplate.queryForObject(query, Boolean.class, LoginReq.getUsername(), LoginReq.getPassword());
        return ret;
    }
}

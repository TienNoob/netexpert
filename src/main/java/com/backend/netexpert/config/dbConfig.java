package com.backend.netexpert.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class dbConfig {

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String greeting() {
        String sql = "SELECT version()";
        String dbVersion = jdbcTemplate.queryForObject(sql, String.class);
        return "Hello, World! PostgreSQL version: " + dbVersion;
    }
}

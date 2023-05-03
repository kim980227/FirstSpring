package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class userRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public userRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void save(String name){
        String query ="insert into member(name) values(?)";
        jdbcTemplate.update(query, name);
    }

}

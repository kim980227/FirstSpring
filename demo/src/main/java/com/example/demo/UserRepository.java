package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(String name) {
        String query = "insert into member(name) values(?)";
        jdbcTemplate.update(query, name);
    }

    public List<Member> findAll() {
        String query = "select * from member";
        return jdbcTemplate.query(query, memberRowMapper());
    }

    // 쿼리문 결과를 담기 위해 자료구조
    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member todo = new Member();
            todo.setId(rs.getLong("id"));
            todo.setName(rs.getString("name"));
            return todo;
        };
    }
}

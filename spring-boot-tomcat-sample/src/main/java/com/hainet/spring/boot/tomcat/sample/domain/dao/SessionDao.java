package com.hainet.spring.boot.tomcat.sample.domain.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class SessionDao {

    private final JdbcTemplate jdbc;

    public List<Map<String, Object>> findAll() {
        return jdbc.queryForList("SELECT * FROM INFORMATION_SCHEMA.SESSIONS");
    }
}

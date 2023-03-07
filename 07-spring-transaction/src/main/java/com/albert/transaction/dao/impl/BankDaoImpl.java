package com.albert.transaction.dao.impl;

import com.albert.transaction.dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankDaoImpl implements BankDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void in(String name, long money) {
        String sql = """
                UPDATE
                    learn.bank
                SET account = account+?
                WHERE name = ?
                """;
        int update = jdbcTemplate.update(sql, money, name);
    }

    @Override
    public void out(String name, long money) {
        String sql = """
                UPDATE
                    learn.bank
                SET account = account-?
                WHERE name = ?
                """;
        int update = jdbcTemplate.update(sql, money, name);
    }
}

package com.springtest.dao.third;

public class ThirdDao {

    private JdbcContext jdbcContext;

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public void deleteAll() {
        jdbcContext.deleteAll();
    }
}

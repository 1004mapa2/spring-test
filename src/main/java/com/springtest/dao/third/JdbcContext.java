package com.springtest.dao.third;

public class JdbcContext {
    Strategy strategy;

    public JdbcContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void deleteAll() {
        System.out.println(strategy.getSql());

    }
}

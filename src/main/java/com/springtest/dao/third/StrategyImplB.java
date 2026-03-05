package com.springtest.dao.third;

public class StrategyImplB implements Strategy {
    @Override
    public String getSql() {
        return "B";
    }
}

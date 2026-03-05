package com.springtest.dao.third;

public class StrategyImplA implements Strategy {
    @Override
    public String getSql() {
        return "A";
    }
}

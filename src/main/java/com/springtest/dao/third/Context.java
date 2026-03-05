package com.springtest.dao.third;

public class Context {

    public static void main(String[] args) {
        ThirdDao thirdDao = new ThirdDao();
        thirdDao.setJdbcContext(new JdbcContext(new StrategyImplA()));
        thirdDao.deleteAll();

    }
}

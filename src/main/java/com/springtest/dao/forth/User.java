package com.springtest.dao.forth;

import lombok.Getter;

@Getter
public class User {

    String id;
    String name;
    Level level;
    int login;
    int recommend;

    public User() {
    }

    public User(String id, String name, Level level, int login, int recommend) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.login = login;
        this.recommend = recommend;
    }

    public static User of(String id, String name, Level level, int login, int recommend) {
        return new User(id, name, level, login, recommend);
    }

    public void upgradeLevel() {
        Level nextLevel = this.level.nextLevel();
        if(nextLevel == null) {
            throw new IllegalArgumentException(this.level + "은 업그레이드 불가");
        } else {
            this.level = nextLevel;
        }
    }
}

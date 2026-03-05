package com.springtest.dao;

import com.springtest.dao.forth.Level;
import com.springtest.dao.forth.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    User user1;
    User user2;
    User user3;

    @BeforeEach
    public void setUp() {
        this.user1 = User.of("id1", "park1", Level.BASIC, 10, 30);
        this.user2 = User.of("id2", "park2", Level.SILVER, 20, 40);
        this.user3 = User.of("id3", "park3", Level.GOLD, 30, 50);
    }

    @Test
    void asdf() {
        assertThat("aa").isEqualTo("aa");
    }

    @Test
    void qwer() {
        assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0;
        });

    }

    @Test
    public void addAndGet() {
        User testUser = User.of("id1", "park1", Level.BASIC, 10, 30);
        checkSameUser(testUser, this.user2);
    }

    private void checkSameUser(User user1, User user2) {
        assertThat(user1.getId()).isEqualTo(user2.getId());
        assertThat(user1.getName()).isEqualTo(user2.getName());
        assertThat(user1.getLevel()).isEqualTo(user2.getLevel());
        assertThat(user1.getLogin()).isEqualTo(user2.getLogin());
        assertThat(user1.getRecommend()).isEqualTo(user2.getRecommend());
    }
}
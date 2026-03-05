package com.springtest.dao.forth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.springtest.dao.forth.UserService.users;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void test() {
        assertThat(1).isEqualTo(userService.asdf());
    }

    @Test
    void upgradeLevels() throws InterruptedException {
        userService.upgradeLevels();
        Thread.sleep(10000);
//        checkLevel(users.get(0), true);
//        checkLevel(users.get(0), false);
//        checkLevel(users.get(1), true);
//        checkLevel(users.get(1), false);
//        checkLevel(users.get(2), true);
//        checkLevel(users.get(2), false);

    }

    private void checkLevel(User user, Boolean upgraded) {
        if(upgraded) {
            assertThat(user.getLevel()).isEqualTo(user.getLevel().nextLevel());
        } else {
            assertThat(user.getLevel()).isEqualTo(user.getLevel());
        }
    }
}
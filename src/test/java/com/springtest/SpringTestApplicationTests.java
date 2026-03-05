package com.springtest;

import com.springtest.dao.forth.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringTestApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

    }

}

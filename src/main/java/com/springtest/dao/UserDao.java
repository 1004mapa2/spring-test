package com.springtest.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDao {

    @Bean
    public String asdf() {
        return "11";
    }
}

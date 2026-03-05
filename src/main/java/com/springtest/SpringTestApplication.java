package com.springtest;

import com.springtest.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserDao.class);
        String asdf = context.getBean("asdf", String.class);
        System.out.println(asdf);
    }

}

package com.springtest.six;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactoryBean;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.assertThat;

public class ProxyTest {

    @Test
    void test() {
        try {
            String name = "park";

            assertThat(name.length()).isEqualTo(4);

            //reflection
            Method lengthMethod = name.getClass().getMethod("length");
            assertThat((int)lengthMethod.invoke(name)).isEqualTo(4);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Test
    void simpleProxy() {
        Hello hello = new HelloTarget();
        assertThat(hello.sayHello("park")).isEqualTo("Hello park");
        assertThat(hello.sayHi("park")).isEqualTo("Hi park");
        assertThat(hello.sayThankYou("park")).isEqualTo("Thank You park");

        Hello proxyHello = new HelloUppercase(hello);
        assertThat(proxyHello.sayHello("park")).isEqualTo("HELLO PARK");
        assertThat(proxyHello.sayHi("park")).isEqualTo("HI PARK");
        assertThat(proxyHello.sayThankYou("park")).isEqualTo("THANK YOU PARK");
    }

    @Test
    void handlerTest() {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{Hello.class}, new UppercaseHandler(new HelloTarget()));
        System.out.println(proxiedHello.sayThankYou("park"));
        System.out.println(proxiedHello.invokeTest("park"));
    }

    @Test
    void proxyFactoryBean() {
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new HelloTarget());
        pfBean.addAdvice(new UppercaseAdvice());
        Hello proxiedHello = (Hello) pfBean.getObject();
        assertThat(proxiedHello.sayHello("park")).isEqualTo("HELLO PARK");
    }

    static class UppercaseAdvice implements MethodInterceptor {
        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            String ret = (String) invocation.proceed();
            return ret.toUpperCase();
        }
    }
}

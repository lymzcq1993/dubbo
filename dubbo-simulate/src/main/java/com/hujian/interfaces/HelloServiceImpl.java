package com.hujian.interfaces;

/**
 * @description:
 * @author: hujian
 * @create: 2021-01-28 22:35
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String username) {
        return username;
    }
}

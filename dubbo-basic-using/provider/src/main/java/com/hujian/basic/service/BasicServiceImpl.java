package com.hujian.basic.service;

import com.hujian.interfaces.BasicService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @description:
 * @author: hujian
 * @create: 2021-02-01 21:33
 */
@Service
public class BasicServiceImpl implements BasicService {
    @Override
    public String sayHello(String name) {
        return "hello "+name;
    }
}

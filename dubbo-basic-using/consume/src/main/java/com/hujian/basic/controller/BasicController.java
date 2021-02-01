package com.hujian.basic.controller;

import com.hujian.interfaces.BasicService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @author: hujian
 * @create: 2021-02-01 22:10
 */
@RestController()
public class BasicController {
    @Reference
    BasicService basicService;

    @RequestMapping("/say")
    public String sayHello(String name){
        return basicService.sayHello(name);
    }
}

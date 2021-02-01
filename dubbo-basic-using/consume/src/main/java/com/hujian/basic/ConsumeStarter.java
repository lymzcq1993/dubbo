package com.hujian.basic;

import com.hujian.basic.controller.BasicController;
import com.hujian.interfaces.BasicService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @description: 服务提供者启动器
 * @author: hujian
 * @create: 2021-02-01 21:24
 */
@SpringBootApplication
public class ConsumeStarter {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConsumeStarter.class, args);

        BasicController bean = context.getBean(BasicController.class);
        System.out.println(bean);
    }

}

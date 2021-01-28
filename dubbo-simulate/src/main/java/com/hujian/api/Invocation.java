package com.hujian.api;

import com.hujian.interfaces.HelloService;
import com.hujian.interfaces.proxy.ProxyFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @description: 传输的封装类
 * @author: hujian
 * @create: 2021-01-28 21:37
 */
@Getter
@Setter
@AllArgsConstructor
public class Invocation {
    private String interfaceName;
    private String methodName;
    private Class[] paramTypes;
    private Object[] params;

    public static void main(String[] args) {
        HelloService proxy = (HelloService)ProxyFactory.getProxy(HelloService.class);
        String m = proxy.sayHello("hujian");
        System.out.println(m);
    }
}

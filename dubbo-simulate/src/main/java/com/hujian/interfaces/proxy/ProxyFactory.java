package com.hujian.interfaces.proxy;

import com.hujian.api.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 代理工厂类
 * @author: hujian
 * @create: 2021-01-28 21:29
 */
public class ProxyFactory {
    public static <T> T getProxy(final Class clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},
                (proxy, method, args) ->
                    {
                        Invocation i = new Invocation(clazz.getName(),method.getName(),method.getParameterTypes(),args);

                        System.out.println(i.toString());
                        return i;
                    }
                );
    }
}

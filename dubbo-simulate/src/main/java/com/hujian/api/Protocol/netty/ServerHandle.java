package com.hujian.api.Protocol.netty;

import com.hujian.api.Invocation;
import com.hujian.interfaces.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.Method;

/**
 * @description: 处理器
 * @author: hujian
 * @create: 2021-01-28 22:32
 */
public class ServerHandle extends SimpleChannelInboundHandler<Invocation> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Invocation invocation) throws Exception {
        Class clazz = Class.forName(invocation.getInterfaceName());
        Method method = clazz.getMethod(invocation.getMethodName(), invocation.getParamTypes());
        String result = (String)method.invoke(new HelloServiceImpl(), invocation.getParams());
        System.out.println(result);
    }
}

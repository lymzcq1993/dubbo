package com.hujian.api.Protocol.netty;

import com.hujian.api.Invocation;
import com.hujian.interfaces.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;

/**
 * @description: 处理器
 * @author: hujian
 * @create: 2021-01-28 22:32
 */
public class ClientHandle extends SimpleChannelInboundHandler<String> {
    String result = "";
    CountDownLatch countDownLatch = new CountDownLatch(1);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        result = msg;
        System.out.println(result);
        countDownLatch.countDown();
    }

    public String getResult(){
        try {
            countDownLatch.wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //重置
        countDownLatch = new CountDownLatch(1);
        return result;
    }
}

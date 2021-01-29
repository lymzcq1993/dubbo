package com.hujian.api.Protocol.netty.client;

import com.hujian.api.Invocation;
import com.hujian.api.Protocol.netty.ObjectEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author hujian
 * @description
 * @date 2021/1/29 10:03
 */
public class NettyClient {
    private ClientHandle clientHandle;
    private Bootstrap bootstrap;

    public void send(String host, int port, Invocation invocation) {
        if (clientHandle == null){
            start(host,port);
        }
        clientHandle.getResult(invocation,bootstrap);
    }

    private void start(String host,int port) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        clientHandle = new ClientHandle();
        bootstrap = new Bootstrap();
        bootstrap.group( workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new ObjectEncoder());

                        pipeline.addLast(clientHandle);
                    }
                });
        try {
            ChannelFuture sync = bootstrap.bind(host, port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

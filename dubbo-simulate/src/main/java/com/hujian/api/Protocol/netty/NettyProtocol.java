package com.hujian.api.Protocol.netty;

import com.hujian.api.Invocation;
import com.hujian.api.Protocol.Protocol;
import com.hujian.api.Protocol.netty.client.NettyClient;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @description: netty
 * @author: hujian
 * @create: 2021-01-28 22:05
 */
public class NettyProtocol implements Protocol {


    @Override
    public void send(String host, int port, Invocation invocation) {
        new NettyClient().send(host,port,invocation);
    }

    /**
     * 启动netty
     */
    @Override
    public void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new ObjectDecoder());
                        pipeline.addLast(new ObjectEncoder());
                    }
                });
    }
}

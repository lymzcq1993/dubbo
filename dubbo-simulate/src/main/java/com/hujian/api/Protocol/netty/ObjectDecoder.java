package com.hujian.api.Protocol.netty;

import com.hujian.api.Invocation;
import com.hujian.util.ProtostuffUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @description: 解码
 * @author: hujian
 * @create: 2021-01-28 22:17
 */
public class ObjectDecoder extends ByteToMessageDecoder {

    int length;
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        //这里因为是传的一组，长度-对象，是一对，所以首先读取到的一定是长度
        if(byteBuf.readableBytes() >= 4){
            if(length == 0){
                length = byteBuf.readInt();
            }
            //检测对象的长度是否和传递过来的长度相等
            if(byteBuf.readableBytes() < length){
                System.out.println("可读字节数不够...");
                return;
            }
            byte[] bytes = new byte[length];
            byteBuf.readBytes(bytes);
            Invocation i = ProtostuffUtil.deserializer(bytes, Invocation.class);
            list.add(i);
            //读取完一组数据后进行重置
            length = 0;
        }
    }
}

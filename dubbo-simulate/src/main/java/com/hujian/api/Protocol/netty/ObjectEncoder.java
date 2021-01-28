package com.hujian.api.Protocol.netty;

import com.hujian.api.Invocation;
import com.hujian.util.ProtostuffUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * @description: 解码
 * @author: hujian
 * @create: 2021-01-28 22:17
 */
public class ObjectEncoder extends MessageToByteEncoder<Invocation> {

    /**
     *
     * @param channelHandlerContext
     * @param i   传递的对象信息
     * @param out    编码后的字节流
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Invocation i, ByteBuf out) throws Exception {
        byte[] bytes = ProtostuffUtil.serializer(i);
        out.writeInt(bytes.length);
        out.writeBytes(bytes);
    }
}

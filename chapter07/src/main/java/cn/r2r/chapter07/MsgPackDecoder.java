package cn.r2r.chapter07;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf>{
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf buffer, List<Object> list) throws Exception {
        final byte[] array;
        final int length = buffer.readableBytes();
        array = new byte[length];
        buffer.getBytes(buffer.readerIndex(),array,0,length);
        MessagePack msgPack = new MessagePack();
        list.add(msgPack.read(array));
    }
}

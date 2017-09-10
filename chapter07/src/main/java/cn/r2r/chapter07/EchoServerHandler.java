package cn.r2r.chapter07;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.msgpack.MessagePack;
import sun.plugin2.message.Message;

public class EchoServerHandler extends ChannelHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("EchoServerHandler ---> channelActive");
//        ctx.write("hello");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("EchoServerHandler ---> channelRead");
        System.out.println("Server receive msgpack message : " + msg);
    }
}

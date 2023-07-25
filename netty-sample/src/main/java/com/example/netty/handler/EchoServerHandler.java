package com.example.netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        String message = (String)msg;
        log.info("Server Recv : {}", message);
        Channel channel = ctx.channel();
        channel.writeAndFlush("Response : '" + message + "' received\n");

        if ("quit".equals(message)) {
            ctx.close();
        }
    }
}

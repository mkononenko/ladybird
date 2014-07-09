package com.myco.ladybird.server.common.netty.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 *
 * @author mkononenko
 */
public class ResponseEncoder extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext channelHandlerContext, Object message, ChannelPromise promise) throws Exception {
        //super.write(channelHandlerContext, message, promise);

        ChannelFuture future = channelHandlerContext.writeAndFlush(new TextWebSocketFrame("HI"), promise);
        //future.addListener(ChannelFutureListener.CLOSE);
    }
}

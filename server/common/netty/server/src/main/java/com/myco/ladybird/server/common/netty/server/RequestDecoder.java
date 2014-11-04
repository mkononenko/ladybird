package com.myco.ladybird.server.common.netty.server;

import com.myco.ladybird.server.common.netty.server.exchange.ExchangeFactory;
import com.myco.ladybird.server.common.netty.server.exchange.NettyRequest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 *
 * @author mkononenko
 */
public class RequestDecoder extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final ExchangeFactory exchangeFactory;

    public RequestDecoder(ExchangeFactory exchangeFactory) {
        this.exchangeFactory = exchangeFactory;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame msg) throws Exception {
        NettyRequest<?> nettyRequest = exchangeFactory.createNettyRequest(msg.content().array());
        channelHandlerContext.fireChannelRead(nettyRequest);
    }
}

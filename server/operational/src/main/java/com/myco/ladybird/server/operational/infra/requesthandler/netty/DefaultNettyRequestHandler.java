package com.myco.ladybird.server.operational.infra.requesthandler.netty;

import com.myco.ladybird.server.common.exchange.AcceptResponse;
import com.myco.ladybird.server.common.exchange.ExchangeRequest;
import com.myco.ladybird.server.common.exchange.Response;
import com.myco.ladybird.server.common.netty.server.exchange.NettyRequest;
import com.myco.ladybird.server.operational.service.processor.AsyncableRequestProcessor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 *
 * @author mkononenko
 */
public class DefaultNettyRequestHandler extends SimpleChannelInboundHandler<NettyRequest<?>> {

    private AsyncableRequestProcessor<ExchangeRequest<? extends Response>, ? extends AcceptResponse> requestProcessor;

    public void setRequestProcessor(AsyncableRequestProcessor<ExchangeRequest<? extends Response>, ? extends AcceptResponse> requestProcessor) {
        this.requestProcessor = requestProcessor;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, NettyRequest<?> nettyRequest) throws Exception {
        requestProcessor.process(nettyRequest.getRequest());
    }
}

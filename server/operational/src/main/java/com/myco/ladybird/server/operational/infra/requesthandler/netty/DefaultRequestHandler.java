package com.myco.ladybird.server.operational.infra.requesthandler.netty;

import com.myco.ladybird.server.operational.service.exchange.netty.OperationalNettyRequest;
import com.myco.ladybird.server.operational.service.processor.MessageProcessor;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 *
 * @author mkononenko
 */
public class DefaultRequestHandler extends SimpleChannelInboundHandler<OperationalNettyRequest> {

    private MessageProcessor requestProcessor;

    public void setRequestProcessor(MessageProcessor requestProcessor) {
        this.requestProcessor = requestProcessor;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, OperationalNettyRequest operationalNettyRequest) throws Exception {
        requestProcessor.process(operationalNettyRequest.getRequest());
    }
}

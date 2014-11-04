package com.myco.ladybird.server.operational.service.exchange.netty;

import com.myco.ladybird.server.common.exchange.AbstractRequest;
import com.myco.ladybird.server.common.exchange.ExchangeRequest;
import com.myco.ladybird.server.common.exchange.Response;
import com.myco.ladybird.server.common.netty.server.exchange.NettyRequest;
import com.myco.ladybird.server.common.netty.server.exchange.NettyResponse;

/**
 *
 * @author mkononenko
 */
public class DefaultNettyRequest extends AbstractRequest<NettyResponse> implements NettyRequest<NettyResponse> {

    private final ExchangeRequest<? extends Response> exchangeRequest;

    public DefaultNettyRequest(ExchangeRequest<? extends Response> exchangeRequest) {
        this.exchangeRequest = exchangeRequest;
    }

    @Override
    public ExchangeRequest<? extends Response> getRequest() {
        return exchangeRequest;
    }

    @Override
    public NettyResponse createResponse() {
        return new DefaultNettyResponse();
    }
}

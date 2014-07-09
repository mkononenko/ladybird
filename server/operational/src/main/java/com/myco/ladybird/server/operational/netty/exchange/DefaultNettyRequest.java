package com.myco.ladybird.server.operational.netty.exchange;

import com.myco.ladybird.common.exchange.endpoint.ExchangeRequestPayload;
import com.myco.ladybird.server.common.netty.server.exchange.NettyRequest;

/**
 *
 * @author mkononenko
 */
public class DefaultNettyRequest implements NettyRequest {

    private final ExchangeRequestPayload exchangeRequestPayload;

    public DefaultNettyRequest(ExchangeRequestPayload exchangeRequestPayload) {
        this.exchangeRequestPayload = exchangeRequestPayload;
    }

    public ExchangeRequestPayload getExchangeRequestPayload() {
        return exchangeRequestPayload;
    }
}

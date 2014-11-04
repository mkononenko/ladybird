package com.myco.ladybird.server.common.netty.server.exchange;

import com.myco.ladybird.server.common.exchange.ExchangeRequest;
import com.myco.ladybird.server.common.exchange.Request;
import com.myco.ladybird.server.common.exchange.Response;

/**
 *
 * @author mkononenko
 */
public interface NettyRequest<T extends NettyResponse> extends Request<T> {

    ExchangeRequest<? extends Response> getRequest();
}

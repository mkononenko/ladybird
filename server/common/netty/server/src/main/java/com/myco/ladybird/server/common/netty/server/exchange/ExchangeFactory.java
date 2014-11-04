package com.myco.ladybird.server.common.netty.server.exchange;

/**
 *
 * @author mkononenko
 */
public interface ExchangeFactory {

    <T extends NettyResponse> NettyRequest<T> createNettyRequest(byte[] bytes);
}

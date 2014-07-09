package com.myco.ladybird.server.common.netty.server.exchange;

/**
 *
 * @author mkononenko
 */
public interface ExchangeFactory {

    NettyRequest createNettyRequest(byte[] bytes);
}

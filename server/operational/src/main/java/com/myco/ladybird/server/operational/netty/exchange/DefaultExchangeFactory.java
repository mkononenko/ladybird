package com.myco.ladybird.server.operational.netty.exchange;

import com.myco.ladybird.common.exchange.endpoint.ExchangeRequest;
import com.myco.ladybird.server.common.netty.server.exchange.ExchangeFactory;
import com.myco.ladybird.server.common.netty.server.exchange.NettyRequest;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mkononenko
 */
public class DefaultExchangeFactory implements ExchangeFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExchangeFactory.class);

    @Override
    public NettyRequest createNettyRequest(byte[] bytes) {
        TDeserializer deserializer = new TDeserializer();
        ExchangeRequest exchangeRequest = new ExchangeRequest();
        try {
            deserializer.deserialize(exchangeRequest, bytes);
        } catch (TException te) {
            LOGGER.error("Failed to deserialize Exchange Request", te);
        }
        return new DefaultNettyRequest(exchangeRequest.getPayload());
    }
}

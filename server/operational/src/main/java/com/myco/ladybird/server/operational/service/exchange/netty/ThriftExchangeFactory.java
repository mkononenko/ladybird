package com.myco.ladybird.server.operational.service.exchange.netty;

import com.myco.ladybird.common.exchange.endpoint.ExchangeRequestPayload;
import com.myco.ladybird.server.common.exchange.ExchangeRequest;
import com.myco.ladybird.server.common.exchange.Response;
import com.myco.ladybird.server.common.netty.server.exchange.ExchangeFactory;
import com.myco.ladybird.server.common.netty.server.exchange.NettyRequest;
import com.myco.ladybird.server.operational.service.exchange.request.impl.thrift.ThriftCreateAccountRequest;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mkononenko
 */
public class ThriftExchangeFactory implements ExchangeFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThriftExchangeFactory.class);

    @Override
    public NettyRequest createNettyRequest(byte[] bytes) {
        TDeserializer deserializer = new TDeserializer();
        com.myco.ladybird.common.exchange.endpoint.ExchangeRequest exchangeRequest = new com.myco.ladybird.common.exchange.endpoint.ExchangeRequest();
        try {
            deserializer.deserialize(exchangeRequest, bytes);
        } catch (TException te) {
            LOGGER.error("Failed to deserialize Exchange Request", te);
        }
        return new DefaultNettyRequest(toOperationalRequest(exchangeRequest.getPayload()));
    }

    private ExchangeRequest<? extends Response> toOperationalRequest(ExchangeRequestPayload exchangeRequestPayload) {
        ExchangeRequest<? extends Response> operationalRequest = null;
        if (exchangeRequestPayload.isSetCreateAccountRequest()) {
            operationalRequest = new ThriftCreateAccountRequest(exchangeRequestPayload.getCreateAccountRequest());
        }
        return operationalRequest;
    }
}

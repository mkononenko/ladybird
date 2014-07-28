package com.myco.ladybird.server.operational.service.exchange.netty;

import com.myco.ladybird.server.operational.service.exchange.request.OperationalRequest;

/**
 *
 * @author mkononenko
 */
public class DefaultNettyRequest implements OperationalNettyRequest {

    private final OperationalRequest operationalRequest;

    public DefaultNettyRequest(OperationalRequest operationalRequest) {
        this.operationalRequest = operationalRequest;
    }

    @Override
    public OperationalRequest getRequest() {
        return operationalRequest;
    }
}

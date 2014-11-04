package com.myco.ladybird.server.operational.service.exchange;

import com.myco.ladybird.server.common.exchange.AsyncRequestType;

/**
 *
 * @author mkononenko
 */
public enum ExchangeType implements AsyncRequestType {

    CREATE_ACCOUNT;

    @Override
    public boolean isA(AsyncRequestType other) {
        return this == other;
    }
}

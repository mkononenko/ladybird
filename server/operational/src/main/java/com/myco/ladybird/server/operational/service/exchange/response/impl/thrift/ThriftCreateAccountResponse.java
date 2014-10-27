package com.myco.ladybird.server.operational.service.exchange.response.impl.thrift;

import com.myco.ladybird.common.exchange.endpoint.CreateAccountResponse;
import com.myco.ladybird.server.operational.service.exchange.ExchangeType;
import com.myco.ladybird.server.operational.service.exchange.request.impl.thrift.ThriftCreateAccountRequest;
import com.myco.ladybird.server.operational.service.exchange.response.OperationalCreateAccountResponse;

/**
 *
 * @author mkononenko
 */
public class ThriftCreateAccountResponse implements OperationalCreateAccountResponse {

    private CreateAccountResponse createAccountResponse;

    public ThriftCreateAccountResponse(ThriftCreateAccountRequest thriftCreateAccountRequest) {
        createAccountResponse = new CreateAccountResponse();
    }

    @Override
    public ExchangeType getType() {
        return ExchangeType.CREATE_ACCOUNT;
    }
}

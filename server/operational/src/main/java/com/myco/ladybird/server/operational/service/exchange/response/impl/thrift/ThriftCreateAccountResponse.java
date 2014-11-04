package com.myco.ladybird.server.operational.service.exchange.response.impl.thrift;

import com.myco.ladybird.server.common.exchange.AbstractResponse;
import com.myco.ladybird.server.common.service.account.exchange.CreateAccountResponse;
import com.myco.ladybird.server.operational.service.exchange.request.impl.thrift.ThriftCreateAccountRequest;

/**
 *
 * @author mkononenko
 */
public class ThriftCreateAccountResponse extends AbstractResponse implements CreateAccountResponse {

    private com.myco.ladybird.common.exchange.endpoint.CreateAccountResponse createAccountResponse;

    public ThriftCreateAccountResponse(ThriftCreateAccountRequest thriftCreateAccountRequest) {
        createAccountResponse = new com.myco.ladybird.common.exchange.endpoint.CreateAccountResponse();
    }
}

package com.myco.ladybird.server.operational.service.exchange.request.impl.thrift;

import com.myco.ladybird.common.exchange.endpoint.CreateAccountRequest;
import com.myco.ladybird.server.operational.service.exchange.ExchangeType;
import com.myco.ladybird.server.operational.service.exchange.request.OperationalCreateAccountRequest;
import com.myco.ladybird.server.operational.service.exchange.response.OperationalCreateAccountResponse;
import com.myco.ladybird.server.operational.service.exchange.response.impl.thrift.ThriftCreateAccountResponse;

/**
 *
 * @author mkononenko
 */
public class ThriftCreateAccountRequest implements OperationalCreateAccountRequest {

    private final CreateAccountRequest createAccountRequest;

    public ThriftCreateAccountRequest(com.myco.ladybird.common.exchange.endpoint.CreateAccountRequest createAccountRequest) {
        this.createAccountRequest = createAccountRequest;
    }

    @Override
    public OperationalCreateAccountResponse createResponse() {
        ThriftCreateAccountResponse response = new ThriftCreateAccountResponse(this);
        return response;
    }

    @Override
    public ExchangeType getType() {
        return ExchangeType.CREATE_ACCOUNT;
    }

    @Override
    public byte[] getPassword() {
        return createAccountRequest.getPassword();
    }

    @Override
    public String getEmail() {
        if (createAccountRequest.getAccountInfo() != null) {
            return createAccountRequest.getAccountInfo().getEmail();
        }
        return null;
    }

    @Override
    public String getPhone() {
        if (createAccountRequest.getAccountInfo() != null) {
            return createAccountRequest.getAccountInfo().getPhone();
        }
        return null;
    }
}

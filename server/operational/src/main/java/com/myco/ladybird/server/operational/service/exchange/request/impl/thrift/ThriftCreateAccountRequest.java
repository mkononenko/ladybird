package com.myco.ladybird.server.operational.service.exchange.request.impl.thrift;

import com.myco.ladybird.server.common.exchange.AbstractRequest;
import com.myco.ladybird.server.common.exchange.AcceptResponse;
import com.myco.ladybird.server.common.exchange.AsyncRequestType;
import com.myco.ladybird.server.common.service.account.exchange.CreateAccountRequest;
import com.myco.ladybird.server.common.service.account.exchange.CreateAccountResponse;
import com.myco.ladybird.server.operational.service.exchange.response.impl.thrift.ThriftCreateAccountResponse;

/**
 *
 * @author mkononenko
 */
public class ThriftCreateAccountRequest extends AbstractRequest<CreateAccountResponse> implements CreateAccountRequest {

    private final com.myco.ladybird.common.exchange.endpoint.CreateAccountRequest createAccountRequest;

    public ThriftCreateAccountRequest(com.myco.ladybird.common.exchange.endpoint.CreateAccountRequest createAccountRequest) {
        this.createAccountRequest = createAccountRequest;
    }

    @Override
    public CreateAccountResponse createResponse() {
        ThriftCreateAccountResponse response = new ThriftCreateAccountResponse(this);
        return response;
    }

    @Override
    public AcceptResponse createAcceptResponse() {
        return null; //TODO
    }

    @Override
    public AsyncRequestType getAsyncRequestType() {
        return null; //TODO
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

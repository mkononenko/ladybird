package com.myco.ladybird.server.operational.service.exchange.request.impl.thrift;

import com.myco.ladybird.server.operational.service.exchange.ExchangeType;
import com.myco.ladybird.server.operational.service.exchange.request.AccountInfo;
import com.myco.ladybird.server.operational.service.exchange.request.CreateAccountRequest;

/**
 *
 * @author mkononenko
 */
public class ThriftCreateAccountRequest implements CreateAccountRequest {

    private final com.myco.ladybird.common.exchange.endpoint.CreateAccountRequest createAccountRequest;
    private AccountInfo accountInfo;

    public ThriftCreateAccountRequest(com.myco.ladybird.common.exchange.endpoint.CreateAccountRequest createAccountRequest) {
        this.createAccountRequest = createAccountRequest;
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
    public AccountInfo getAccountInfo() {
        if (accountInfo == null) {
            accountInfo = AccountInfoConverter.fromThriftAccountInfo(createAccountRequest.getAccountInfo());
        }
        return accountInfo;
    }
}

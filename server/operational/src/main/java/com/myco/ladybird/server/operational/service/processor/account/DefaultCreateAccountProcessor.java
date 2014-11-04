package com.myco.ladybird.server.operational.service.processor.account;

import com.myco.ladybird.server.common.service.account.exchange.CreateAccountRequest;
import com.myco.ladybird.server.common.service.account.exchange.CreateAccountResponse;
import com.myco.ladybird.server.operational.service.processor.AbstractControllableRequestProcessor;

/**
 *
 * @author mkononenko
 */
public class DefaultCreateAccountProcessor extends AbstractControllableRequestProcessor<CreateAccountRequest, CreateAccountResponse> implements CreateAccountProcessor {

    @Override
    public CreateAccountResponse process(CreateAccountRequest createAccountRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO : implement me
    }
}

package com.myco.ladybird.server.operational.service.processor.account;

import com.myco.ladybird.server.operational.service.exchange.request.CreateAccountRequest;
import com.myco.ladybird.server.operational.service.processor.AbstractControllableMessageProcessor;

/**
 *
 * @author mkononenko
 */
public class DefaultCreateAccountProcessor extends AbstractControllableMessageProcessor<CreateAccountRequest> implements CreateAccountProcessor {

    @Override
    public void process(CreateAccountRequest createAccountRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

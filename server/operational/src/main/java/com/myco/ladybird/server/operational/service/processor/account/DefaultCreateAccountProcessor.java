package com.myco.ladybird.server.operational.service.processor.account;

import com.myco.ladybird.server.operational.service.exchange.request.OperationalCreateAccountRequest;
import com.myco.ladybird.server.operational.service.processor.AbstractControllableMessageProcessor;

/**
 *
 * @author mkononenko
 */
public class DefaultCreateAccountProcessor extends AbstractControllableMessageProcessor<OperationalCreateAccountRequest> implements CreateAccountProcessor {

    @Override
    public void process(OperationalCreateAccountRequest createAccountRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

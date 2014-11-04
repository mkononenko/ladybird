package com.myco.ladybird.server.operational.service.processor.account;

import com.myco.ladybird.server.common.service.account.exchange.CreateAccountRequest;
import com.myco.ladybird.server.common.service.account.exchange.CreateAccountResponse;
import com.myco.ladybird.server.operational.service.processor.ControllableRequestProcessor;

/**
 *
 * @author mkononenko
 */
public interface CreateAccountProcessor extends ControllableRequestProcessor<CreateAccountRequest, CreateAccountResponse> {
}

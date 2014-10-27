package com.myco.ladybird.server.common.service.account.exchange.transformer.request;

import com.myco.ladybird.server.common.core.model.Account;
import com.myco.ladybird.server.common.service.account.exchange.CreateAccountRequest;

/**
 *
 * @author mkononenko
 */
public interface AccountRequestTransformer {

    Account createAccountRequestToAccount(CreateAccountRequest createAccountRequest);
}

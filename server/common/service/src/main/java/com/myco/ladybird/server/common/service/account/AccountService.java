package com.myco.ladybird.server.common.service.account;

import com.myco.ladybird.server.common.service.account.exchange.CreateAccountRequest;
import com.myco.ladybird.server.common.service.account.exchange.CreateAccountResponse;

/**
 *
 * @author mkononenko
 */
public interface AccountService {

    CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest);
}

package com.myco.ladybird.server.common.service.account;

import com.myco.ladybird.server.common.service.account.exchange.CreateAccountRequest;
import com.myco.ladybird.server.common.core.model.Account;
import com.myco.ladybird.server.common.dao.AccountDao;
import com.myco.ladybird.server.common.service.account.exchange.CreateAccountResponse;
import com.myco.ladybird.server.common.service.account.exchange.transformer.request.AccountRequestTransformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mkononenko
 */
@Service
public class DefaultAccountService implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAccountService.class);
    @Autowired
    private AccountDao<Account> accountDao;
    //@Autowired
    private AccountRequestTransformer accountRequestTransformer;

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create Account request: {}", createAccountRequest);
        }

        Account account = accountRequestTransformer.createAccountRequestToAccount(createAccountRequest);
        account = accountDao.save(account);

        LOGGER.debug("Created Account: {}", account);

        CreateAccountResponse createAccountResponse = createAccountRequest.createResponse();
        return createAccountResponse;
    }
}

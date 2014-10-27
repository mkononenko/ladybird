package com.myco.ladybird.server.common.service.account.exchange.transformer.request.mongo;

import com.myco.ladybird.server.common.core.model.Account;
import com.myco.ladybird.server.common.core.model.mongo.AccountMongo;
import com.myco.ladybird.server.common.service.account.exchange.CreateAccountRequest;
import com.myco.ladybird.server.common.service.account.exchange.transformer.request.AccountRequestTransformer;

/**
 *
 * @author mkononenko
 */
public class MongoAccountRequestTransformer implements AccountRequestTransformer {

    @Override
    public Account createAccountRequestToAccount(CreateAccountRequest createAccountRequest) {
        AccountMongo account = new AccountMongo();
        account.setEmail(createAccountRequest.getEmail());
        account.setPhone(createAccountRequest.getPhone());

        return account;
    }
}

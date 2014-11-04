package com.myco.ladybird.server.common.service.account.exchange;

import com.myco.ladybird.server.common.exchange.ExchangeRequest;

/**
 *
 * @author mkononenko
 */
public interface CreateAccountRequest extends ExchangeRequest<CreateAccountResponse> {

    byte[] getPassword();

    String getEmail();

    String getPhone();
}

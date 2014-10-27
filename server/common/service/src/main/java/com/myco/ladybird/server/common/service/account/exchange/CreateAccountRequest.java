package com.myco.ladybird.server.common.service.account.exchange;

/**
 *
 * @author mkononenko
 */
public interface CreateAccountRequest extends Request<CreateAccountResponse>{

    byte[] getPassword();

    String getEmail();

    String getPhone();
}

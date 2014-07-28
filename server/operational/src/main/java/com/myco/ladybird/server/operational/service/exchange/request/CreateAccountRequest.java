package com.myco.ladybird.server.operational.service.exchange.request;

/**
 *
 * @author mkononenko
 */
public interface CreateAccountRequest extends OperationalRequest {

    byte[] getPassword();

    AccountInfo getAccountInfo();
}

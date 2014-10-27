package com.myco.ladybird.server.common.service.account.exchange;

/**
 *
 * @author mkononenko
 */
public interface Request<T extends Response> {

    T createResponse();
}

package com.myco.ladybird.server.common.exchange;

/**
 *
 * @author mkononenko
 */
public interface Request<R extends Response> extends Message {

    R createResponse();
}

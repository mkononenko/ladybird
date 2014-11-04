package com.myco.ladybird.server.common.exchange;

/**
 *
 * @author mkononenko
 */
public interface AsyncableRequest<R extends Response> extends Request<R> {

    AcceptResponse createAcceptResponse();

    AsyncRequestType getAsyncRequestType();
}

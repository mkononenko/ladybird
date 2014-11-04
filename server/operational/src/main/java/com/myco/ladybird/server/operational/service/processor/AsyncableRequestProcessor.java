package com.myco.ladybird.server.operational.service.processor;

import com.myco.ladybird.server.common.exchange.AcceptResponse;
import com.myco.ladybird.server.common.exchange.AsyncableRequest;
import com.myco.ladybird.server.common.exchange.Response;

/**
 *
 * @author mkononenko
 */
public interface AsyncableRequestProcessor<T extends AsyncableRequest<? extends Response>, R extends AcceptResponse> extends RequestProcessor<T, R> {
}

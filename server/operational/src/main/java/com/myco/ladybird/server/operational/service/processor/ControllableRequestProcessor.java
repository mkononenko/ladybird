package com.myco.ladybird.server.operational.service.processor;

import com.myco.ladybird.server.common.exchange.Request;
import com.myco.ladybird.server.common.exchange.Response;

/**
 *
 * @author mkononenko
 */
public interface ControllableRequestProcessor<T extends Request<? extends Response>, R extends Response> extends ControllableMessageProcessor<T, R> {
}

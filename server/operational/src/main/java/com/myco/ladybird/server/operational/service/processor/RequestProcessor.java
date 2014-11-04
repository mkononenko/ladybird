package com.myco.ladybird.server.operational.service.processor;

import com.myco.ladybird.server.common.exchange.Request;
import com.myco.ladybird.server.common.exchange.Response;

/**
 *
 * @author mkononenko
 */
public interface RequestProcessor<T extends Request<? extends Response>, R extends Response> extends MessageProcessor<T, R> {
}

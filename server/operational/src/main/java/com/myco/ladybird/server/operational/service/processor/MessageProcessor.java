package com.myco.ladybird.server.operational.service.processor;

import com.myco.ladybird.server.common.exchange.Message;

/**
 *
 * @author mkononenko
 * @param <T>
 */
public interface MessageProcessor<T extends Message, R extends Message> {

    R process(T message);
}

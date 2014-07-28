package com.myco.ladybird.server.operational.service.processor;

import com.myco.ladybird.server.operational.service.exchange.OperationalMessage;

/**
 *
 * @author mkononenko
 * @param <T>
 */
public interface MessageProcessor<T extends OperationalMessage> {

    void process(T operationalMessage);
}

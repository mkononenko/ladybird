package com.myco.ladybird.server.operational.service.processor;

import com.myco.ladybird.server.common.exchange.Message;

public interface ControllableMessageProcessor<T extends Message, R extends Message> extends MessageProcessor<T, R> {

    void start();

    void stop();
}

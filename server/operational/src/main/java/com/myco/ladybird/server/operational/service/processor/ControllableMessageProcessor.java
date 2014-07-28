package com.myco.ladybird.server.operational.service.processor;

import com.myco.ladybird.server.operational.service.exchange.OperationalMessage;

public interface ControllableMessageProcessor<T extends OperationalMessage> extends MessageProcessor<T> {

    void start();

    void stop();
}

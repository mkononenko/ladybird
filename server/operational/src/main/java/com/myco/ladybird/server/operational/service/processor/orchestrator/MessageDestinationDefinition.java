package com.myco.ladybird.server.operational.service.processor.orchestrator;

import com.myco.ladybird.server.common.exchange.Message;
import com.myco.ladybird.server.operational.service.processor.ControllableMessageProcessor;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author mkononenko
 * @param <R>
 * @param <C>
 */
public class MessageDestinationDefinition<R extends Message, C extends ControllableMessageProcessor<R, ? extends Message>> {

    private BlockingQueue<R> queue;
    private Class<C> processorClass;

    public MessageDestinationDefinition() {
    }

    public BlockingQueue<R> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<R> queue) {
        this.queue = queue;
    }

    public Class<C> getProcessorClass() {
        return processorClass;
    }

    public void setProcessorClass(Class<C> processorClass) {
        this.processorClass = processorClass;
    }
}

package com.myco.ladybird.server.operational.service.processor.orchestrator;

import com.myco.ladybird.server.common.exchange.Message;
import com.myco.ladybird.server.operational.service.processor.ControllableMessageProcessor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author mkononenko
 */
public class MessageDispatcher implements Runnable {

    private final List<BlockingQueue<? extends Message>> queues;
    private final Map<BlockingQueue<? extends Message>, ? extends ControllableMessageProcessor<Message, Message>> messageProcessorsMap;
    private final ExecutorService executorService;
    private volatile boolean cancelled;

    public MessageDispatcher(List<BlockingQueue<? extends Message>> queues, Map<BlockingQueue<? extends Message>, ControllableMessageProcessor<Message, Message>> messageProcessorsMap, ExecutorService executorService) {
        this.queues = queues;
        this.messageProcessorsMap = messageProcessorsMap;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        while (!cancelled) {
            for (final BlockingQueue<? extends Message> queue : queues) {
                if (cancelled) {
                    break;
                }
                final Message message = queue.poll();
                if (message != null) {
                    executorService.submit(new Runnable() {

                        @Override
                        public void run() {
                            messageProcessorsMap.get(queue).process(message);
                        }
                    });
                }
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }
}

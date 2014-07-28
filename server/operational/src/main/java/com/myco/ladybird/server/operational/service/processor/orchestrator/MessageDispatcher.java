package com.myco.ladybird.server.operational.service.processor.orchestrator;

import com.myco.ladybird.server.operational.service.exchange.OperationalMessage;
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

    private final List<BlockingQueue<OperationalMessage>> queues;
    private final Map<BlockingQueue<OperationalMessage>, ControllableMessageProcessor<OperationalMessage>> messageProcessorsMap;
    private final ExecutorService executorService;
    private volatile boolean cancelled;

    public MessageDispatcher(List<BlockingQueue<OperationalMessage>> queues, Map<BlockingQueue<OperationalMessage>, ControllableMessageProcessor<OperationalMessage>> messageProcessorsMap, ExecutorService executorService) {
        this.queues = queues;
        this.messageProcessorsMap = messageProcessorsMap;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        while (!cancelled) {
            for (final BlockingQueue<OperationalMessage> queue : queues) {
                if (cancelled) {
                    break;
                }
                final OperationalMessage operationalMessage = queue.poll();
                if (operationalMessage != null) {
                    executorService.submit(new Runnable() {

                        @Override
                        public void run() {
                            messageProcessorsMap.get(queue).process(operationalMessage);
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

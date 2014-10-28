package com.myco.ladybird.server.operational.service.processor.orchestrator;

import com.myco.ladybird.server.operational.service.exchange.OperationalMessage;
import com.myco.ladybird.server.operational.service.processor.ControllableMessageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultProcessorOrchestrator implements ProcessorOrchestrator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultProcessorOrchestrator.class);
    //////////
    private List<MessageDestinationDefinition> messageDestinationDefinitions;
    private int messageDispatcherCount;
    private ExecutorService messageDispatcherExecutor;
    private ExecutorService messageProcessorExecutor;
    private final Map<BlockingQueue<OperationalMessage>, ControllableMessageProcessor<OperationalMessage>> messageProcessorsMap = new ConcurrentHashMap<>();
    private final List<MessageDispatcher> messageDispatchers = new CopyOnWriteArrayList<>();

    @Override
    public void start() {
        for (MessageDestinationDefinition messageDestinationDefinition : messageDestinationDefinitions) {
            try {
                ControllableMessageProcessor<OperationalMessage> controllableMessageProcessor = (ControllableMessageProcessor<OperationalMessage>) messageDestinationDefinition.getProcessorClass().newInstance();
                messageProcessorsMap.put(messageDestinationDefinition.getQueue(), controllableMessageProcessor);
            } catch (InstantiationException | IllegalAccessException ex) {
                LOGGER.error("Failed to instantiate ControllableMessageProcessor", ex);
            }
        }

        List<List<BlockingQueue<OperationalMessage>>> buckets = createBucketsOfQueues(messageDispatcherCount);
        for (List<BlockingQueue<OperationalMessage>> bucket : buckets) {
            MessageDispatcher messageDispatcher = new MessageDispatcher(bucket, messageProcessorsMap, messageProcessorExecutor);
            messageDispatchers.add(messageDispatcher);
            messageDispatcherExecutor.submit(messageDispatcher);
        }
    }

    @Override
    public void stop() {
        for (MessageDispatcher messageDispatcher : messageDispatchers) {
            messageDispatcher.cancel();
        }
        messageDispatcherExecutor.shutdownNow();
        messageProcessorExecutor.shutdownNow();
    }

    @Override
    public void setMessageDestinationDefinitions(List<MessageDestinationDefinition> messageDestinationDefinitions) {
        this.messageDestinationDefinitions = messageDestinationDefinitions;
    }

    public void setMessageDispatcherCount(int messageDispatcherCount) {
        this.messageDispatcherCount = messageDispatcherCount;
    }

    public void setMessageDispatcherExecutor(ExecutorService messageDispatcherExecutor) {
        this.messageDispatcherExecutor = messageDispatcherExecutor;
    }

    public void setMessageProcessorExecutor(ExecutorService messageProcessorExecutor) {
        this.messageProcessorExecutor = messageProcessorExecutor;
    }

    // TODO : smart queues bucketing
    private List<List<BlockingQueue<OperationalMessage>>> createBucketsOfQueues(int bucketsCount) {
        int queuesCount = messageDestinationDefinitions.size();
        int queuesPerBucket = queuesCount / bucketsCount;
        List<List<BlockingQueue<OperationalMessage>>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketsCount; i++) {
            List<BlockingQueue<OperationalMessage>> bucket = new ArrayList<>();
            for (int j = i * queuesPerBucket; j < queuesPerBucket * (i + 1) && j < queuesCount; j++) {
                bucket.add(messageDestinationDefinitions.get(j).getQueue());
            }
            buckets.add(bucket);
        }
        return buckets;
    }
}

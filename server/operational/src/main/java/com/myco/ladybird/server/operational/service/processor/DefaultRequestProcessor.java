package com.myco.ladybird.server.operational.service.processor;

import com.myco.ladybird.server.operational.service.exchange.request.OperationalRequest;

import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author mkononenko
 */
@Service
public class DefaultRequestProcessor implements MessageProcessor<OperationalRequest> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRequestProcessor.class);

    @Resource
    private BlockingQueue<OperationalRequest> createAccountQueue;

    public BlockingQueue<OperationalRequest> getCreateAccountQueue() {
        return createAccountQueue;
    }

    public void setCreateAccountQueue(BlockingQueue<OperationalRequest> createAccountQueue) {
        this.createAccountQueue = createAccountQueue;
    }

    @Override
    public void process(OperationalRequest operationalRequest) {
        switch (operationalRequest.getType()) {
            case CREATE_ACCOUNT:
                createAccountQueue.offer(operationalRequest);
                break;
            default:
                LOGGER.warn("Unknown operational request type: {}", operationalRequest.getType());
                break;
        }
    }
}

package com.myco.ladybird.server.operational.service.processor;

import com.myco.ladybird.server.common.exchange.AcceptResponse;
import com.myco.ladybird.server.common.exchange.AsyncRequestType;
import com.myco.ladybird.server.common.exchange.AsyncableRequest;
import com.myco.ladybird.server.common.exchange.Response;
import com.myco.ladybird.server.operational.service.exchange.ExchangeType;

import java.util.UUID;
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
public class DefaultAsyncableRequestProcessor implements AsyncableRequestProcessor<AsyncableRequest<? extends Response>, AcceptResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAsyncableRequestProcessor.class);
    @Resource
    private BlockingQueue<AsyncableRequest<? extends Response>> createAccountQueue;
    @Resource
    private BlockingQueue<AcceptResponse> acceptResponseQueue;

    public BlockingQueue<AsyncableRequest<? extends Response>> getCreateAccountQueue() {
        return createAccountQueue;
    }

    public void setCreateAccountQueue(BlockingQueue<AsyncableRequest<? extends Response>> createAccountQueue) {
        this.createAccountQueue = createAccountQueue;
    }

    @Override
    public AcceptResponse process(AsyncableRequest<? extends Response> request) {
        AsyncRequestType asyncRequestType = request.getAsyncRequestType();
        boolean requestAccepted = true;
        if (ExchangeType.CREATE_ACCOUNT.isA(asyncRequestType)) {
            createAccountQueue.offer(request);
            request.createAcceptResponse();
        } else {
            requestAccepted = false;
            LOGGER.warn("Unknown operational request type: {}", asyncRequestType);
        }

        AcceptResponse acceptResponse;
        if (requestAccepted) {
            acceptResponse = request.createAcceptResponse();
        } else {
            acceptResponse = new AcceptResponse() {

                @Override
                public UUID getId() {
                    return UUID.randomUUID();
                }
            }; // TODO : create Null Accept Response
        }

        acceptResponseQueue.offer(acceptResponse);

        return acceptResponse;
    }
}

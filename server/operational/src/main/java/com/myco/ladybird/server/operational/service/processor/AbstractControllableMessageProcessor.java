package com.myco.ladybird.server.operational.service.processor;

import com.myco.ladybird.server.operational.service.exchange.request.OperationalRequest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 *
 * @author mkononenko
 * @param <T>
 */
public abstract class AbstractControllableMessageProcessor<T extends OperationalRequest> implements ControllableMessageProcessor<T>, Runnable {

    protected ExecutorService executor;
    protected BlockingQueue<T> queue;
    private volatile boolean isRunnable;
    private Future<?> future;

    @Override
    public void start() {
        isRunnable = true;
        future = executor.submit(this);
    }

    @Override
    public void stop() {
        isRunnable = false;
        future.cancel(true);
        future = null;
    }

    @Override
    public void run() {
        while (isRunnable) {
            try {
                T request = queue.take();
                process(request);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

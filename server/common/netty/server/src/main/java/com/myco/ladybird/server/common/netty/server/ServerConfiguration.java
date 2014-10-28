package com.myco.ladybird.server.common.netty.server;

import com.myco.ladybird.server.common.netty.server.exchange.ExchangeFactory;

import io.netty.channel.SimpleChannelInboundHandler;

/**
 *
 * @author mkononenko
 */
public class ServerConfiguration {

    private int executorThreadSize = ServerConfigurationConstants.DEFAULT_EXECUTOR_THREAD_SIZE;
    private String bindInterface = ServerConfigurationConstants.DEFAULT_BIND_INTERFACE;
    private int port = ServerConfigurationConstants.DEFAULT_PORT;
    private ExchangeFactory exchangeFactory;
    private SimpleChannelInboundHandler requestHandler;
    private SessionTracker sessionTracker;

    public int getExecutorThreadSize() {
        return executorThreadSize;
    }

    public void setExecutorThreadSize(int executorThreadSize) {
        this.executorThreadSize = executorThreadSize;
    }

    public String getBindInterface() {
        return bindInterface;
    }

    public void setBindInterface(String bindInterface) {
        this.bindInterface = bindInterface;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ExchangeFactory getExchangeFactory() {
        return exchangeFactory;
    }

    public void setExchangeFactory(ExchangeFactory exchangeFactory) {
        this.exchangeFactory = exchangeFactory;
    }

    public SimpleChannelInboundHandler getRequestHandler() {
        return requestHandler;
    }

    public void setRequestHandler(SimpleChannelInboundHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public SessionTracker getSessionTracker() {
        return sessionTracker;
    }

    public void setSessionTracker(SessionTracker sessionTracker) {
        this.sessionTracker = sessionTracker;
    }
}

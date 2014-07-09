package com.myco.ladybird.server.common.netty.server;

import com.myco.ladybird.server.common.netty.server.exchange.ExchangeFactory;

import io.netty.channel.ChannelInboundHandler;

/**
 *
 * @author mkononenko
 */
public class ServerConfiguration {

    private int executorThreadSize = ServerConfigurationConstants.DEFAULT_EXECUTOR_THREAD_SIZE;
    private String bindInterface = ServerConfigurationConstants.DEFAULT_BIND_INTERFACE;
    private int port = ServerConfigurationConstants.DEFAULT_PORT;
    private ExchangeFactory exchangeFactory;
    private ChannelInboundHandler requestHandler;

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

    public ChannelInboundHandler getRequestHandler() {
        return requestHandler;
    }

    public void setRequestHandler(ChannelInboundHandler requestHandler) {
        this.requestHandler = requestHandler;
    }
}

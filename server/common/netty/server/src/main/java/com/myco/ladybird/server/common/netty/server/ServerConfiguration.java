package com.myco.ladybird.server.common.netty.server;

/**
 *
 * @author mkononenko
 */
public class ServerConfiguration {

    private int executorThreadSize = ServerConfigurationConstants.DEFAULT_EXECUTOR_THREAD_SIZE;
    private String bindInterface = ServerConfigurationConstants.DEFAULT_BIND_INTERFACE;
    private int port = ServerConfigurationConstants.DEFAULT_PORT;

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
}

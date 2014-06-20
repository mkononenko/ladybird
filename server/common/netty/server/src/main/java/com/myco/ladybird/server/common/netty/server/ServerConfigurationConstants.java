package com.myco.ladybird.server.common.netty.server;

/**
 *
 * @author mkononenko
 */
public final class ServerConfigurationConstants {

    public static final int DEFAULT_EXECUTOR_THREAD_SIZE = 3;
    public static final String DEFAULT_BIND_INTERFACE = "any";
    public static final int DEFAULT_PORT = 9998;

    private ServerConfigurationConstants() {
        throw new UnsupportedOperationException("Not supported");
    }
}

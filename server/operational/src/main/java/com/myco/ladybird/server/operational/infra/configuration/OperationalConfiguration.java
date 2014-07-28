package com.myco.ladybird.server.operational.infra.configuration;

import com.myco.ladybird.server.common.netty.server.ServerConfiguration;

/**
 *
 * @author mkononenko
 */
public class OperationalConfiguration {

    private ServerConfiguration nettyServerConfiguration;

    public ServerConfiguration getNettyServerConfiguration() {
        return nettyServerConfiguration;
    }

    public void setNettyServerConfiguration(ServerConfiguration nettyServerConfiguration) {
        this.nettyServerConfiguration = nettyServerConfiguration;
    }
}

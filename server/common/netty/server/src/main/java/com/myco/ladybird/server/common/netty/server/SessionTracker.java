package com.myco.ladybird.server.common.netty.server;

import io.netty.channel.Channel;

import java.util.UUID;

/**
 *
 * @author mkononenko
 */
public interface SessionTracker {

    void sessionStarted(Channel channel, UUID id);

    void sessionFinished(Channel channel, UUID id);
}

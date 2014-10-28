package com.myco.ladybird.server.operational.service.cache.session;

import io.netty.channel.Channel;

import java.util.UUID;

/**
 *
 * @author mkononenko
 */
public interface SessionCache {

    void addSession(Channel channel, UUID id);

    void removeSession(Channel channel, UUID id);

    Channel getSession(UUID id);
}

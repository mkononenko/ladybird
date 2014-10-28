package com.myco.ladybird.server.operational.service.cache.session;

import io.netty.channel.Channel;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mkononenko
 */
public class DefaultSessionCache implements SessionCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSessionCache.class);
    //////////
    private ConcurrentMap<UUID, Channel> channels = new ConcurrentHashMap<>();

    @Override
    public void addSession(Channel channel, UUID id) {
        Channel previousChannel;
        if ((previousChannel = channels.putIfAbsent(id, channel)) != null) {
            LOGGER.warn("Channel is already associated with id [{}]; previous channel: {}; new channel: {}", id, previousChannel, channel);
        }
    }

    @Override
    public void removeSession(Channel channel, UUID id) {
        if (!channels.remove(id, channel)) {
            LOGGER.warn("Channel is not associated with id [{}]; channel: {}", id, channel);
        }
    }

    @Override
    public Channel getSession(UUID id) {
        return channels.get(id);
    }
}

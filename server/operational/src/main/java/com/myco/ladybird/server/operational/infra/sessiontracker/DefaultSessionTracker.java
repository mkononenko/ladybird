package com.myco.ladybird.server.operational.infra.sessiontracker;

import com.myco.ladybird.server.common.netty.server.SessionTracker;
import com.myco.ladybird.server.operational.service.cache.session.SessionCache;

import io.netty.channel.Channel;

import java.util.UUID;

/**
 *
 * @author mkononenko
 */
public class DefaultSessionTracker implements SessionTracker {

    private SessionCache sessionCache;

    public void setSessionCache(SessionCache sessionCache) {
        this.sessionCache = sessionCache;
    }

    @Override
    public void sessionStarted(Channel channel, UUID id) {
        sessionCache.addItem(id, channel);
    }

    @Override
    public void sessionFinished(Channel channel, UUID id) {
        sessionCache.removeItem(id, channel);
    }
}

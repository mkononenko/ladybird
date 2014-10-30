package com.myco.ladybird.server.operational.service.cache.session;

import com.myco.ladybird.server.operational.service.cache.CacheService;

import io.netty.channel.Channel;

import java.util.UUID;

/**
 *
 * @author mkononenko
 */
public interface SessionCache extends CacheService<UUID, Channel> {
}

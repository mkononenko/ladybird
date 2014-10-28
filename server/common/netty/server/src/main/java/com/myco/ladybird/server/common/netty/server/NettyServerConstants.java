package com.myco.ladybird.server.common.netty.server;

import io.netty.util.AttributeKey;

import java.util.UUID;

/**
 *
 * @author mkononenko
 */
public final class NettyServerConstants {

    public static final String ATTRIBUTE_SESSION_ID = "SESSION_ID";
    //////////
    public static final AttributeKey<UUID> CHANNEL_ATTRIBUTE_KEY_SESSION_ID = AttributeKey.valueOf(NettyServerConstants.ATTRIBUTE_SESSION_ID);

    private NettyServerConstants() {
        throw new UnsupportedOperationException("Not supported");
    }
}

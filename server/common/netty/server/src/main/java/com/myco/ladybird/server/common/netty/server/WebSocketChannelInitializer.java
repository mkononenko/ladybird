package com.myco.ladybird.server.common.netty.server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.util.Attribute;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.util.UUID;

/**
 *
 * @author mkononenko
 */
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    private ServerConfiguration serverConfiguration;

    @Override
    protected void initChannel(final SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();

        final UUID uuid = UUID.randomUUID();

        Attribute<UUID> sessionIdAttribute = channel.attr(NettyServerConstants.CHANNEL_ATTRIBUTE_KEY_SESSION_ID);
        sessionIdAttribute.set(uuid);

        if (serverConfiguration.getSessionTracker() != null) {
            serverConfiguration.getSessionTracker().sessionStarted(channel, uuid);
        }

        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new WebSocketServerHandler());
        pipeline.addLast(new RequestDecoder(serverConfiguration.getExchangeFactory()));
        pipeline.addLast(new ResponseEncoder());
        pipeline.addLast(serverConfiguration.getRequestHandler());

        ChannelFuture closeFuture = channel.closeFuture();
        closeFuture.addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future)
                    throws Exception {
                if (serverConfiguration.getSessionTracker() != null) {
                    serverConfiguration.getSessionTracker().sessionFinished(channel, uuid);
                }
            }
        });
    }

    public void setServerConfiguration(ServerConfiguration serverConfiguration) {
        this.serverConfiguration = serverConfiguration;
    }
}

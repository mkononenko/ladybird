package com.myco.ladybird.server.common.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 *
 * @author mkononenko
 */
public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {

    private ServerConfiguration serverConfiguration;

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));
        pipeline.addLast(new WebSocketServerHandler());
        pipeline.addLast(new RequestDecoder(serverConfiguration.getExchangeFactory()));
        pipeline.addLast(new ResponseEncoder());
        pipeline.addLast(serverConfiguration.getRequestHandler());
    }

    public void setServerConfiguration(ServerConfiguration serverConfiguration) {
        this.serverConfiguration = serverConfiguration;
    }
}

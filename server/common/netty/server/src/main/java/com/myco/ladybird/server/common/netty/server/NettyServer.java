package com.myco.ladybird.server.common.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mkononenko
 */
public class NettyServer extends Thread {

    private static final Logger LOG = LoggerFactory.getLogger(NettyServer.class);
    //////////
    private final ServerConfiguration serverConfiguration;
    //////////
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ServerBootstrap serverBootstrap;
    //private EventExecutorGroup executor;
    private Channel bindChannel;
    private String bindAddress;

    public NettyServer(ServerConfiguration serverConfiguration) {
        this.serverConfiguration = serverConfiguration;
        LOG.debug("NettyServer configuration:{}{}", System.getProperty("line.separator"), serverConfiguration);
    }

    public void init() {
        try {
            LOG.info("NettyServer Initializing...");
            bossGroup = new NioEventLoopGroup();

            LOG.debug("NettyServer bossGroup created");
            workerGroup = new NioEventLoopGroup();
            LOG.debug("NettyServer workGroup created");
            serverBootstrap = new ServerBootstrap();
            LOG.debug("NettyServer ServerBootstrap created");
//            executor = new DefaultEventExecutorGroup(serverConfiguration.getExecutorThreadSize());
//            LOG.debug("NettyServer Task Executor created");
            ChannelInitializer channelInitializer = new WebSocketServerInitializer();

            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class).childHandler(channelInitializer)
                    .option(ChannelOption.SO_REUSEADDR, true);
            LOG.debug("NettyServer ServerBootstrap group initialized");

            bindAddress = serverConfiguration.getBindInterface();
            bindChannel = serverBootstrap.bind(bindAddress, serverConfiguration.getPort()).sync().channel();
        } catch (InterruptedException e) {
            LOG.error("NettyServer init() failed", e);
        }
    }

    @Override
    public void run() {
        LOG.info("NettyServer starting...");
        try {
            bindChannel.closeFuture().sync();
        } catch (InterruptedException e) {
            LOG.error("NettyServer error", e);
        } finally {
            shutdown();
            LOG.info("NettyServer shut down");
        }
    }

    public void shutdown() {
        LOG.info("NettyServer stopping...");
        if (bossGroup != null) {
            try {
                Future<?> future = bossGroup.shutdownGracefully();
                future.await();
            } catch (InterruptedException e) {
                LOG.trace("NettyServer stopping: bossGroup error", e);
            } finally {
                bossGroup = null;
                LOG.trace("NettyServer stopping: bossGroup stoped");
            }
        }
        if (workerGroup != null) {
            try {
                Future<?> future = workerGroup.shutdownGracefully();
                future.await();
            } catch (InterruptedException e) {
                LOG.trace("NettyServer stopping: workerGroup error", e);
            } finally {
                workerGroup = null;
                LOG.trace("NettyServer stopping: workerGroup stopped");
            }
        }
//        if (executor != null) {
//            try {
//                Future<?> future = executor.shutdownGracefully();
//                future.await();
//            } catch (InterruptedException e) {
//                LOG.trace("NettyServer stopping: task executor error", e);
//            } finally {
//                executor = null;
//                LOG.trace("NettyServer stopping: task executor stopped.");
//            }
//        }
    }

    public void deInit() {
        LOG.info("NettyServer deInitializing...");
    }

    public ServerConfiguration getServerConfiguration() {
        return serverConfiguration;
    }

    public String getBindAddress() {
        return bindAddress;
    }
}

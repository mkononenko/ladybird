package com.myco.ladybird.server.common.netty.server.tcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mkononenko
 */
public class NettyTcpServer extends Thread {

    private static final Logger LOG = LoggerFactory.getLogger(NettyTcpServer.class);
//    public static final AttributeKey<UUID> UUID_KEY = new AttributeKey<>(ConfigConst.UUID_KEY);
//    public static final AttributeKey<Track> TRACK_KEY = new AttributeKey<>(ConfigConst.TRACK_KEY);
//
//
//    private EventLoopGroup bossGroup;
//    private EventLoopGroup workerGroup;
//    private ServerBootstrap bServer;
//    private EventExecutorGroup executor;
//    private Channel bindChannel;
//
//    private final Config conf;
//
    private String bindAddress;
//
//    /**
//     * Config getter.
//     * @return Config
//     */
//    public Config getConf() {
//        return conf;
//    }
//
//    /**
//     * NettyHttpServer constructor.
//     * @param conf Config
//     */

    public NettyTcpServer(/*Config conf*/) {
        //this.conf = conf;
        //LOG.trace("NettyTcpServer config:\n{}", conf.toString());
    }

    public void init() {
//        try {
//            LOG.info("NettyHttpServer Initializing...");
//            bossGroup = new NioEventLoopGroup();
//
//            LOG.debug("NettyHttpServer bossGroup created");
//            workerGroup = new NioEventLoopGroup();
//            LOG.debug("NettyHttpServer workGroup created");
//            bServer = new ServerBootstrap();
//            LOG.debug("NettyHttpServer ServerBootstrap created");
//            executor = new DefaultEventExecutorGroup(conf.getExecutorThreadSize());
//            LOG.debug("NettyHttpServer Task Executor created");
//            DefaultServerInitializer sInit = NettyHttpServer
//                    .initClassFromConfig(conf);
//            LOG.debug("NettyHttpServer InitClass instance created");
//
//            sInit.setConf(conf);
//            sInit.setExecutor(executor);
//            sInit.init();
//            sInit.setServer(this);
//            LOG.debug("NettyHttpServer InitClass instance init()");
//            bServer.group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class).childHandler(sInit)
//                    .option(ChannelOption.SO_REUSEADDR, true);
//            LOG.debug("NettyHttpServer ServerBootstrap group initialized");
//            bindChannel = bServer.bind(conf.getBindInterface(), conf.getPort()).sync().channel();
//            bindAddress = conf.getBindInterface();
//        } catch (Exception e) {
//            LOG.error("NettyHttpServer init() failed",e);
//        }
    }

    @Override
    public void run() {
//        LOG.info("NettyHttpServer starting...");
//        try {
//            bindChannel.closeFuture().sync();
//        } catch (InterruptedException e) {
//            LOG.error("NettyHttpServer error", e);
//        } finally {
//            shutdown();
//            LOG.info("NettyHttpServer shut down");
//        }
    }

    /**
     * Netty HTTP server shutdown.
     */
    public void shutdown() {
//        LOG.info("NettyHttpServer stopping...");
//        if (bossGroup != null) {
//            try {
//                Future<? extends Object> f = bossGroup.shutdownGracefully();
//                f.await();
//            } catch (InterruptedException e) {
//                LOG.trace("NettyHttpServer stopping: bossGroup error", e);
//            } finally {
//                bossGroup = null;
//                LOG.trace("NettyHttpServer stopping: bossGroup stoped");
//            }
//        }
//        if (workerGroup != null) {
//            try {
//                Future<? extends Object> f = workerGroup.shutdownGracefully();
//                f.await();
//            } catch (InterruptedException e) {
//                LOG.trace("NettyHttpServer stopping: workerGroup error", e);
//            } finally {
//                workerGroup = null;
//                LOG.trace("NettyHttpServer stopping: workerGroup stopped");
//            }
//        }
//        if (executor != null) {
//            try {
//                Future<? extends Object> f = executor.shutdownGracefully();
//                f.await();
//            } catch (InterruptedException e) {
//                LOG.trace("NettyHttpServer stopping: task executor error", e);
//            } finally {
//                executor = null;
//                LOG.trace("NettyHttpServer stopping: task executor stopped.");
//            }
//        }
    }

    public void deInit() {
        //LOG.info("NettyHttpServer deInitializing...");
    }

//    private static DefaultServerInitializer initClassFromConfig(Config conf)
//            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        LOG.trace("NettyHttpServer initClassFromConfig class: {}", conf.getServerInitializerClass());
//        Class<?> c = null;
//        c = Class.forName(conf.getServerInitializerClass());
//        Object obj = c.newInstance();
//        if (obj instanceof DefaultServerInitializer) {
//            LOG.trace("NettyHttpServer initClassFromConfig class {} created", conf.getServerInitializerClass());
//            return (DefaultServerInitializer) obj;
//        }
//        throw new InstantiationException("Class " + conf.getServerInitializerClass()
//                + " is not an instanceof DefaultServerInitializer");
//    }
    public String getBindAddress() {
        return bindAddress;
    }
}

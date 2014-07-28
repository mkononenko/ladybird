package com.myco.ladybird.server.operational.infra.bootstrap;

import com.myco.ladybird.server.common.netty.server.NettyServer;
import com.myco.ladybird.server.operational.infra.configuration.OperationalConfiguration;
import com.myco.ladybird.server.operational.service.processor.orchestrator.ProcessorOrchestrator;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mkononenko
 */
@Service
public class DefaultOperationalBootstrapService implements OperationalBootstrapService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultOperationalBootstrapService.class);

    @Autowired
    private OperationalConfiguration operationalConfiguration;
    @Autowired
    private ProcessorOrchestrator processorOrchestrator;

    private NettyServer nettyServer;

    @PostConstruct
    public void init() {
        nettyServer = new NettyServer(operationalConfiguration.getNettyServerConfiguration());
    }

    @Override
    public void start() {
        LOGGER.info("Starting Operational server");

        startNetty();

        startInternalServices();
    }

    @Override
    public void stop() {
        LOGGER.info("Stopping Operational server");

        stopNetty();

        stopInternalServices();
    }

    private void startNetty() {
        LOGGER.info("Starting Netty");

        nettyServer.init();
        nettyServer.start();
    }

    private void stopNetty() {
        LOGGER.info("Stopping Netty");

        nettyServer.shutdown();
        nettyServer.deInit();
    }

    private void startInternalServices() {
        LOGGER.info("Starting Internal Services");

        LOGGER.info("Starting Processor Orchestrator");
        processorOrchestrator.start();
    }

    private void stopInternalServices() {
        LOGGER.info("Stopping Internal Services");

        LOGGER.info("Stopping Processor Orchestrator");
        processorOrchestrator.stop();
    }
}

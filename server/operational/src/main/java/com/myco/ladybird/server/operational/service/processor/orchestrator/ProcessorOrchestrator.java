package com.myco.ladybird.server.operational.service.processor.orchestrator;

import java.util.List;

/**
 *
 * @author mkononenko
 */
public interface ProcessorOrchestrator {

    void start();

    void stop();

    void setMessageDestinationDefinitions(List<MessageDestinationDefinition> messageDestinationDefinitions);
}

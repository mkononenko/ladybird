package com.myco.ladybird.server.operational;

import com.myco.ladybird.server.operational.infra.bootstrap.OperationalBootstrapService;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mkononenko
 */
public class Server {

    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    private static final String DEFAULT_APPLICATION_CONTEXT_XML = "operationalContext.xml";

    public static void main(String[] args) {
        LOGGER.info("Application starting.. " + Charset.defaultCharset().name());

        String applicationContextXml = DEFAULT_APPLICATION_CONTEXT_XML;
        if (args.length > 0) {
            applicationContextXml = args[0];
        }
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(applicationContextXml)) {
            OperationalBootstrapService operationalBootstrapService = (OperationalBootstrapService) context.getBean(OperationalBootstrapService.class);
            operationalBootstrapService.start();
        }
        LOGGER.info("Operations Server Application stopped.");
    }
}

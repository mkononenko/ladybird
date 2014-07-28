package com.myco.ladybird.server.operational.service.exchange.netty;

import com.myco.ladybird.server.common.netty.server.exchange.NettyRequest;
import com.myco.ladybird.server.operational.service.exchange.request.OperationalRequest;

/**
 *
 * @author mkononenko
 */
public interface OperationalNettyRequest extends NettyRequest {

    OperationalRequest getRequest();
}

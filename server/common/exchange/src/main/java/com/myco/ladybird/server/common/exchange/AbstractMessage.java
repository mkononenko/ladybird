package com.myco.ladybird.server.common.exchange;

import java.util.UUID;

/**
 *
 * @author mkononenko
 */
public abstract class AbstractMessage implements Message {

    protected UUID id;

    public AbstractMessage() {
        id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return id;
    }
}

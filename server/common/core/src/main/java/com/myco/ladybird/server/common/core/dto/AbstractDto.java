package com.myco.ladybird.server.common.core.dto;

import com.myco.ladybird.server.common.core.model.Id;

/**
 *
 * @author mkononenko
 */
public abstract class AbstractDto implements Dto {

    private Id id;

    @Override
    public Id getId() {
        return id;
    }

    @Override
    public void setId(Id id) {
        this.id = id;
    }
}

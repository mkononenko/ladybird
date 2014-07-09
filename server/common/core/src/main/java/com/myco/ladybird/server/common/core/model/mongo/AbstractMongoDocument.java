package com.myco.ladybird.server.common.core.model.mongo;

import com.myco.ladybird.server.common.core.model.Id;
import com.myco.ladybird.server.common.core.model.Identifiable;

/**
 *
 * @author mkononenko
 */
public abstract class AbstractMongoDocument implements Identifiable {

    @org.springframework.data.annotation.Id
    private String id;

    @Override
    public Id getId() {
        return Id.valueOf(id);
    }
}

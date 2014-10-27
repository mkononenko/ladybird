package com.myco.ladybird.server.common.core.model.mongo;

import com.myco.ladybird.server.common.core.model.AbstractModel;
import com.myco.ladybird.server.common.core.model.Id;

/**
 *
 * @author mkononenko
 */
public abstract class AbstractMongoDocument extends AbstractModel {

    @org.springframework.data.annotation.Id
    protected String id;

    @Override
    public Id getId() {
        return Id.valueOf(id);
    }

    @Override
    public void setId(Id id) {
        if (id == null) {
            this.id = null;
        } else {
            this.id = id.stringValue();
        }
    }
}

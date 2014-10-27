package com.myco.ladybird.server.common.dao.impl.mongo;

import static com.myco.ladybird.server.common.core.model.mongo.MongoConstants.FIELD_ID;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.myco.ladybird.server.common.core.model.Id;
import com.myco.ladybird.server.common.core.model.Model;
import com.myco.ladybird.server.common.dao.Dao;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author mkononenko
 */
public abstract class AbstractMongoDao<T extends Model> implements Dao<T> {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
    //////////
    @Autowired
    protected MongoTemplate mongoTemplate;

    protected abstract String getCollectionName();

    protected abstract Class<T> getDocumentClass();

    @Override
    public T save(T document) {
        LOGGER.debug("Save documents to [{}] collection.", getCollectionName());
        mongoTemplate.save(document);
        return document;
    }

    @Override
    public List<T> findAll() {
        LOGGER.debug("Find  all documents from [{}] collection.", getCollectionName());
        return mongoTemplate.findAll(getDocumentClass());
    }

    @Override
    public T findById(Id id) {
        LOGGER.debug("Find document of collection [{}] by id [{}]", getCollectionName(), id.stringValue());
        return mongoTemplate.findById(id.stringValue(), getDocumentClass());
    }

    @Override
    public void removeAll() {
        LOGGER.debug("Remove all documents from [{}] collection.", getCollectionName());
        mongoTemplate.dropCollection(getDocumentClass());
    }

    @Override
    public void removeById(Id id) {
        LOGGER.debug("Remove document of collection [{}] by id [{}]", getCollectionName(), id.stringValue());
        mongoTemplate.remove(query(where(FIELD_ID).is(new ObjectId(id.stringValue()))), getDocumentClass());
    }
}

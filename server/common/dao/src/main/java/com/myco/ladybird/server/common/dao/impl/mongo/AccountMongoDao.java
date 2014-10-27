package com.myco.ladybird.server.common.dao.impl.mongo;

import com.myco.ladybird.server.common.core.model.mongo.AccountMongo;
import com.myco.ladybird.server.common.dao.AccountDao;

import org.springframework.stereotype.Repository;

/**
 *
 * @author mkononenko
 */
@Repository
public class AccountMongoDao extends AbstractMongoDao<AccountMongo> implements AccountDao<AccountMongo> {

    @Override
    protected String getCollectionName() {
        return "account"; //TODO : move to const
    }

    @Override
    protected Class<AccountMongo> getDocumentClass() {
        return AccountMongo.class;
    }
}

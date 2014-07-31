package com.myco.ladybird.server.common.dao.impl.mongo;

import com.myco.ladybird.server.common.core.model.Id;
import com.myco.ladybird.server.common.core.model.Identifiable;
import com.myco.ladybird.server.common.dao.AccountDao;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mkononenko
 */
@Repository
public class AccountMongoDao implements AccountDao {

    @Override
    public Identifiable save(Identifiable o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Identifiable findById(Id id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeById(Id id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

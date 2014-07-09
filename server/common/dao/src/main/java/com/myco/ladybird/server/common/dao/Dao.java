package com.myco.ladybird.server.common.dao;

import com.myco.ladybird.server.common.core.model.Id;
import com.myco.ladybird.server.common.core.model.Identifiable;

import java.util.List;

/**
 *
 * @author mkononenko
 * @param <T>
 */
public interface Dao<T extends Identifiable> {

    T save(T o);

    List<T> findAll();

    T findById(Id id);

    void removeAll();

    void removeById(Id id);
}

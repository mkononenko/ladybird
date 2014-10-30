package com.myco.ladybird.server.operational.service.cache;

/**
 *
 * @author mkononenko
 */
public interface CacheService<K, I> {

    void addItem(K key, I item);

    void removeItem(K key, I item);

    I getItem(K key);
}

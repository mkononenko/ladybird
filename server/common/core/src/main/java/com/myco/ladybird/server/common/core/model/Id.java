package com.myco.ladybird.server.common.core.model;

/**
 *
 * @author mkononenko
 */
public class Id {

    private final IdType type;
    private final Object value;

    private Id(IdType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public static Id valueOf(Long value) {
        return new Id(IdType.LONG, value);
    }

    public static Id valueOf(String value) {
        return new Id(IdType.STRING, value);
    }

    public IdType type() {
        return type;
    }

    public <T> T value() {
        return (T) value;
    }

    public Long longValue() {
        return value();
    }

    public String stringValue() {
        return value();
    }
}

package com.myco.ladybird.server.common.core.model;

/**
 *
 * @author mkononenko
 */
public interface Account extends Model {

    String getEmail();

    void setEmail(String email);

    String getPhone();

    void setPhone(String phone);
}

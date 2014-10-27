package com.myco.ladybird.server.common.core.model.mongo;

import com.myco.ladybird.server.common.core.model.Account;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author mkononenko
 */
@Document(collection = "account") //TODO : move to const file
//TODO : implement equals and hashcode, toString
public class AccountMongo extends AbstractMongoDocument implements Account {

    private static final long serialVersionUID = 1L;
    //////////
    private String email;
    private String phone;

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }
}

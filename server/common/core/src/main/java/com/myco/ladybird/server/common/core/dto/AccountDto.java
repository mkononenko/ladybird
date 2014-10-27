package com.myco.ladybird.server.common.core.dto;

/**
 *
 * @author mkononenko
 */
// TODO : implement equals, hashCode and toString
public class AccountDto extends AbstractDto {

    private String email;
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

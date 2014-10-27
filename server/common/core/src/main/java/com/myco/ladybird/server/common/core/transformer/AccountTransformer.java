package com.myco.ladybird.server.common.core.transformer;

import com.myco.ladybird.server.common.core.dto.AccountDto;
import com.myco.ladybird.server.common.core.model.Account;
import com.myco.ladybird.server.common.core.model.mongo.AccountMongo;

/**
 *
 * @author mkononenko
 */
public class AccountTransformer extends AbstractTransformer<Account, AccountDto> {

    @Override
    protected AccountDto createDto() {
        return new AccountDto();
    }

    @Override
    protected AccountDto buildDto(AccountDto dto, Account model) {
        dto.setId(model.getId());
        dto.setEmail(model.getEmail());
        dto.setPhone(model.getPhone());

        return dto;
    }

    @Override
    protected AccountMongo createModel() {
        return new AccountMongo();
    }

    @Override
    protected Account buildModel(Account model, AccountDto dto) {
        model.setId(dto.getId());
        model.setEmail(dto.getEmail());
        model.setPhone(dto.getPhone());

        return model;
    }
}

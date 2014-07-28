package com.myco.ladybird.server.operational.service.exchange.request.impl.thrift;

import com.myco.ladybird.server.operational.service.exchange.request.AccountInfo;

/**
 *
 * @author mkononenko
 */
public class AccountInfoConverter {

    public static AccountInfo fromThriftAccountInfo(com.myco.ladybird.common.exchange.endpoint.AccountInfo thriftAccountInfo) {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setEmail(thriftAccountInfo.getEmail());
        accountInfo.setPhone(thriftAccountInfo.getPhone());
        return accountInfo;
    }
}

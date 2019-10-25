package com.zlk.gjj.registerAndAccount.account.service;

import com.zlk.gjj.registerAndAccount.entity.Account;

public interface AccountService {

    Integer insertAccount (Account account);

    String selectAccountByUnitId(String unitId);

    Integer updateAccountById(Account account);

    Account selectAccountByUnitRegisterId(String unitRegisterId);

    Integer deleteAccountByUnitId(String unitId);
}

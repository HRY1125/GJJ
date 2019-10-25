package com.zlk.gjj.registerAndAccount.account.mapper;

import com.zlk.gjj.registerAndAccount.entity.Account;

public interface AccountMapper {

     Integer insertAccount (Account account);

     String selectAccountByUnitId(String unitId);

     Account selectAccountByUnitRegisterId(String unitRegisterId);

     Integer updateAccountById(Account account);

     Integer deleteAccountByUnitId(String unitId);
}

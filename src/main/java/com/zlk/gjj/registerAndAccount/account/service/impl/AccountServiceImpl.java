package com.zlk.gjj.registerAndAccount.account.service.impl;

import com.zlk.gjj.registerAndAccount.account.mapper.AccountMapper;
import com.zlk.gjj.registerAndAccount.account.service.AccountService;
import com.zlk.gjj.registerAndAccount.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Integer insertAccount(Account account) {

        return accountMapper.insertAccount(account);
    }

    @Override
    public String selectAccountByUnitId(String unitId) {
        return accountMapper.selectAccountByUnitId(unitId);
    }
}

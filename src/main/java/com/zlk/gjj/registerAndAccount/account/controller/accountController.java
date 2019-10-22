package com.zlk.gjj.registerAndAccount.account.controller;

import com.zlk.gjj.registerAndAccount.account.service.AccountService;
import com.zlk.gjj.registerAndAccount.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/account")
public class accountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/accountInsert")
    public String insertAccount(Account account){
        /*account.setAccountId("1");
        account.setUnitRegistId("1");
        account.setUnitId("1");
        account.setBusinessKind("1");
        account.setCapitalSource("1");
        account.setAllocateUnit("1");
        account.setIsSecondAssist("1");
        account.setAgentDepartment("1");
        account.setPayDay(1);
        account.setFirstRemitMonth(1);
        account.setUnitDepositeRatio(1);
        account.setIsMonthConfirm("1");*/
        Integer flag = accountService.insertAccount(account);
        if(flag == 1){
            return "index";
        }else {
            return null;
        }
    }
}

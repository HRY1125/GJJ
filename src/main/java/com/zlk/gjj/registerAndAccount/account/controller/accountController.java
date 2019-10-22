package com.zlk.gjj.registerAndAccount.account.controller;

import com.zlk.gjj.registerAndAccount.account.service.AccountService;
import com.zlk.gjj.registerAndAccount.entity.Account;
import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.mapper.UnitRegisterMapper;
import com.zlk.gjj.registerAndAccount.unitRegister.service.UnitRegisterService;
import com.zlk.gjj.registerAndAccount.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/account")
public class accountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UnitRegisterService UnitRegisterService;

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
        account.setAccountId(IDUtils.getUUID());
        Integer flag = accountService.insertAccount(account);
        if(flag == 1){
            return "index";
        }else {
            return null;
        }
    }

    @RequestMapping(value = "/selectAccountByUnitId")
    public String selectAccountByUnitId(String unitId,String unitName, String orgCode){
        UnitRegister unitRegister = new UnitRegister();
        unitRegister.setUnitName("1");
        unitRegister.setOrgCode("1");
        String s = UnitRegisterService.selectUnitRegisterUnitId("1", "1");
        String flag = accountService.selectAccountByUnitId(s);
        if(flag .equals("1")){
            return "index1";
        }else {
            return null;
        }

    }

       @RequestMapping(value = "/updateAccountById")
       public String updateAccountById( Account account){
        account.setAccountId("1");
        account.setPayDay(7);
        Integer flag = accountService.updateAccountById(account);
           if(flag == 1){
               return "index1";
           }else {
               return null;
           }
       }
}

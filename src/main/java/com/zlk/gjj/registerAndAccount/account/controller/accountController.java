package com.zlk.gjj.registerAndAccount.account.controller;

import com.zlk.gjj.registerAndAccount.account.service.AccountService;
import com.zlk.gjj.registerAndAccount.entity.Account;
import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.service.UnitRegisterService;
import com.zlk.gjj.registerAndAccount.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/account")
public class accountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UnitRegisterService UnitRegisterService;

    @RequestMapping(value = "/toUA")
    public String toUA(){
        return "unit_account";
    }

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

        account.setAccountId(IdUtils.getUnitId(9));
        account.setUnitId("2");

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
        String s = UnitRegisterService.selectUnitRegisterUnitId(unitRegister);
        String flag = accountService.selectAccountByUnitId(s);
        if(flag .equals("1")){
            return "index1";
        }else {
            return null;
        }

    }

       @RequestMapping(value = "/updateAccountById")
       @ResponseBody
       public String updateAccountById( Account account){
        Integer flag = accountService.updateAccountById(account);
           if(flag == 1){
               return "修改成功";
           }else {
               return "修改失败";
           }
       }
    @RequestMapping("selectAccountByUnitRegisterId")
    @ResponseBody
    public Account selectAccountByUnitRegisterId(String unitRegisterId){
        Account account=accountService.selectAccountByUnitRegisterId(unitRegisterId);
        return accountService.selectAccountByUnitRegisterId(unitRegisterId);
    }

    @RequestMapping("updatekaihu")
    public String updatekaihu(){

        return "unit_account_update";
    }

    @RequestMapping(value = "/deleteAccountByUnitId")
    public String deleteAccountByUnitId(String unitId) throws  Exception{

        Integer flag = accountService.deleteAccountByUnitId("1");
        if(flag == 1){
            return "index1";
        }else {
            return null;
        }
    }
}

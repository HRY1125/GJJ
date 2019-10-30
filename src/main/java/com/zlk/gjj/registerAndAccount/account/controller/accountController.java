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
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping(value="/account")
public class accountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private UnitRegisterService UnitRegisterService;

    @RequestMapping(value = "/toUA")
    public String toUA() {
        return "unit_account";
    }

    @RequestMapping(value = "/accountInsert")
<<<<<<< HEAD
    public String insertAccount(HttpServletRequest request,Account account) {
=======
    public String insertAccount(Account account,Map map) {

>>>>>>> 63b9659a009efc2daa34be128a385b5358f1e462
        account.setAccountId(IdUtils.getUnitId(9));
        String unitId = (String) request.getSession().getAttribute("ID");
        account.setUnitId(unitId);
        Integer flag = accountService.insertAccount(account);
        if (flag == 1) {
            map.put("retmsg","开户成功");
            return "default";
        } else {
            map.put("retmsg","开户失败");
            return "default";
        }
    }

    @RequestMapping(value = "/selectAccountByUnitId")
    public String selectAccountByUnitId(String unitId, String unitName, String orgCode) {
        UnitRegister unitRegister = new UnitRegister();
        unitRegister.setUnitName("1");
        unitRegister.setOrgCode("1");
        String s = UnitRegisterService.selectUnitRegisterUnitId(unitRegister);

      return null;
    }

    @RequestMapping(value = "/updateAccountById")
    @ResponseBody
    public String updateAccountById(Account account,Map map) {
        Integer flag = accountService.updateAccountById(account);
        if (flag == 1) {
            map.put("retmsg","修改成功");
            return "default";
        } else {
            map.put("retmsg","修改失败");
            return "default";
        }
    }

    @RequestMapping("selectAccountByUnitId2")
    @ResponseBody
    public Account selectAccountByUnitId2(HttpServletRequest request) {
        Account account = accountService.selectAccountByUnitId2((String)request.getSession().getAttribute("ID"));
        return account;
    }

    @RequestMapping("updatekaihu")
    public String updatekaihu(HttpServletRequest request, Map map) {
        String unitId = (String) request.getSession().getAttribute("ID");
        String ret = accountService.selectAccountByUnitId(unitId);
        if (ret == null){
            map.put("retmsg","单位未开户，请先开户");
            return "default";
        }
        return "unit_account_update";
    }

    @RequestMapping(value = "/deleteAccountByUnitId")
    public String deleteAccountByUnitId(String unitId) throws Exception {
        Integer flag = accountService.deleteAccountByUnitId("1");
        if (flag == 1) {
            return "index1";
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/selectAccountBusinessByUnitId")
    @ResponseBody
    public String selectAccountBusinessByUnitId(Account account, String unitId) {
        String s = accountService.selectAccountByUnitId(account.getUnitId());
        return null;
    }
}
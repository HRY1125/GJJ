package com.zlk.gjj.registerAndAccount.payIn.controller;



import com.zlk.gjj.registerAndAccount.entity.Account;
import com.zlk.gjj.registerAndAccount.entity.PayIn;
import com.zlk.gjj.registerAndAccount.payIn.service.PayInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value="/payIn")
public class PayInController {
    @Autowired
    private PayInService PayInService;

    @RequestMapping(value = "/payInInsert")
    public String insertPayIn(HttpServletRequest request, PayIn PayIn, BindingResult bindingResult, Map map){
        /*PayIn.setUnitId("1");
        PayIn.setPayIdId(1);
        PayIn.setUnitRegisterId("1");
        PayIn.setPayMethod("1");
        PayIn.setReceiptUnitName("1");
        PayIn.setReceiptUnitAccount("1");
        PayIn.setReceiptUnitBank("1");
        PayIn.setBankExchangeNum("1");
        PayIn.setPaySusNum("1");
        PayIn.setReceiptDate("1");
        PayIn.setRemitUnitName("1");
        PayIn.setRemitBankName("1");
        PayIn.setRemitUnitAccount(1);*/
        String unitId = (String) request.getSession().getAttribute("ID");
        PayIn.setUnitId(unitId);
        Integer flag = PayInService.insertPayIn(PayIn);


        if(flag == 1){
            map.put("retmsg","发送成功");
            return "default";
        }else {
            map.put("retmsg","发送失败");
            return "default";
        }
    }

        @RequestMapping(value = "/selectPayInByUnitId")
    public String selectPayInByUnitId(String unitId){

        PayIn flag=PayInService.selectPayInByUnitId("1");
        if(flag == null){
            return null;
        }else {

            return "index1";
        }

    }

    @RequestMapping(value = "/updatePayInByUnitId")
    public String updatePayInByUnitId( PayIn payIn){
        payIn.setUnitId("1");
        payIn.setRemitBankName("中国银行");
        Integer flag = PayInService.updatePayInByUnitId(payIn);
        if(flag == 1){
            return "index1";
        }else {
            return null;
        }
    }

}

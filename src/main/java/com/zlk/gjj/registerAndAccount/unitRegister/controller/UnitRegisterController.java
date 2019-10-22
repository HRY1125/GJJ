package com.zlk.gjj.registerAndAccount.unitRegister.controller;



import com.zlk.gjj.registerAndAccount.entity.Unit;
import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.service.UnitRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/unitRegister")
public class UnitRegisterController {

    @Autowired
    private UnitRegisterService UnitRegisterService;

    @RequestMapping(value = "/selectUnitRegisterUnitId")
    public String selectUnitRegisterUnitId(String unitName,String orgCode){

        String s = UnitRegisterService.selectUnitRegisterUnitId("1", "1");
        System.out.println(s);
        return "index1";
    }

}

package com.zlk.gjj.registerAndAccount.sys.controller;

import com.zlk.gjj.registerAndAccount.unitRegister.mapper.UnitRegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private UnitRegisterMapper unitRegisterMapper;

    @RequestMapping("/toFunctions")
    public String toFunctions(){
        return "functions";
    }

    @RequestMapping("/toUA")
    public String toUA(Map map){
        map.put("accountKind","住房补贴");
        return "unit_account";
    }

    @RequestMapping("/toPR")
    public String toPR(){
        return "person_regist";
    }

    @RequestMapping("/toPM")
    public String toPM(){
        return "pay_method";
    }

    @RequestMapping("/toRemit")
    public String toRemit(HttpServletRequest request){
        request.getSession().setAttribute("unitRegistId","111");
        request.getSession().setAttribute("unitName","111");
        request.getSession().setAttribute("source","111");
        request.getSession().setAttribute("unitRatio","111");
        request.getSession().setAttribute("personRatio","111");
        return "remit";
    }

    @RequestMapping("/toUR")
    public String toUR(){
        return "unit_register_detection";
    }

    @RequestMapping("/toCard")
    public String toCard() {
        return "card";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/toAgent")
    public String toAgent() {
        return "agent";
    }

    @RequestMapping("/findURId")
    @ResponseBody
    public Map findURId(@RequestBody String URId){
        String unitName = unitRegisterMapper.selectUnitNameByUnitRegisterId(URId);
        Map map = new HashMap();
        map.put("unitName",unitName);
        return map;
    }

    @RequestMapping("/toSA")
    public String toSA() {
        return "second_assist";
    }

}

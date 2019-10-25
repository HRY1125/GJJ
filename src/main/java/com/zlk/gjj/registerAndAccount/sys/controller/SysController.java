package com.zlk.gjj.registerAndAccount.sys.controller;

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
        return "unit_register";
    }


    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
}

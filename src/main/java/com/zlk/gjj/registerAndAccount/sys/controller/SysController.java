package com.zlk.gjj.registerAndAccount.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String toUA(){
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
    public String toRemit(){
        return "remit";
    }

    @RequestMapping("/ajaxTest")
    @ResponseBody
    public String ajaxTest(){
        return "";
    }
}

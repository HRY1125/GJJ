package com.zlk.gjj.registerAndAccount.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class SysController {

    @RequestMapping("/toFunctions")
    public String toFunctions(){
        return "functions";
    }
}

package com.zlk.gjj.registerAndAccount.unitlogin.controller;

import com.zlk.gjj.registerAndAccount.entity.Unit;
import com.zlk.gjj.registerAndAccount.unitlogin.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: gjj
 * @description: 单位用户注册与登录处理器
 * @author: zyx
 * @create: 2019-10-22 14:49
 */
@Controller
@RequestMapping(value = "/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @RequestMapping(value = "/signin")
    public ModelAndView singIn(Unit unit) throws Exception{
        ModelAndView mv = new ModelAndView();
        unit.setAgentName("李四");
        unit.setPapersName("身份证");
        unit.setPapersNum("129837265427");
        unit.setAgentPhone("1232424");
        unit.setPassword("111111");
        unit.setUnitEmail("123234@123.com");
        unit.setUnitName("alibaba");
        String msg = unitService.insertUnit(unit);
        mv.addObject("msg",msg);
        mv.setViewName("test");
        return mv;
    }

    @RequestMapping(value = "/login")
    public ModelAndView Login(Unit unit) throws Exception{
//        String unitId = unit.getUnitId();
//        String password = unit.getPassword();
        String unitId = "1411";
        String password = "141";
        unit.setUnitId(unitId);
        unit.setPassword(password);
        ModelAndView mv = new ModelAndView();
        String message = unitService.login(unit);
        if(message.equals("登录成功")){
            mv.addObject("message",message);
            mv.setViewName("test");
        }else if(message.equals("登录错误3次，退出系统")){
            mv.addObject("message",message);
            mv.setViewName("test");
        }else {
            mv.addObject("message",message);
            mv.setViewName("test");
        }
        return mv;
    }

}

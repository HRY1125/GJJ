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

    /**
     *  单位用户注册
     *@method singIn
     *@params [unit]
     *@return org.springframework.web.servlet.ModelAndView
     *@author zhang
     *@time 2019/10/23  10:28
     */
    @RequestMapping(value = "/signin")
    public ModelAndView singIn(Unit unit) throws Exception{
        ModelAndView mv = new ModelAndView();
        unit.setAgentName("拉萨的飞机");
        unit.setPapersName("身份证");
        unit.setPapersNum("410928198802021216");
        unit.setAgentPhone("122334");
        unit.setPassword("2222");
        unit.setUnitEmail("1232434@123.com");
        unit.setUnitName("wangyi");
        String msg = unitService.insertUnit(unit);
        mv.addObject("message",msg);
        mv.setViewName("test");
        return mv;
    }

    /**
     *  单位用户登录
     *@method Login
     *@params [unit]
     *@return org.springframework.web.servlet.ModelAndView
     *@author zhang
     *@time 2019/10/23  10:28
     */
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

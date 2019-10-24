package com.zlk.gjj.registerAndAccount.unitlogin.controller;

import com.zlk.gjj.registerAndAccount.entity.Unit;
import com.zlk.gjj.registerAndAccount.unitlogin.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        unit.setAgentName("李四");
        unit.setPapersName("身份证");
        unit.setPapersNum("129837265427");
        unit.setAgentPhone("1232424");
        unit.setPassword("111111");
        unit.setUnitEmail("123234@123.com");
        unit.setUnitName("alibaba");
        String msg = unitService.insertUnit(unit);
        mv.addObject("message",msg);
        mv.setViewName("test");
        return mv;
    }

    /**
     *  普通单位用户登录
     *@method Login
     *@params [unit]
     *@return org.springframework.web.servlet.ModelAndView
     *@author zhang
     *@time 2019/10/23  10:28
     */
    @RequestMapping(value = "/login")
    public ModelAndView Login(HttpServletRequest request,Unit unit,String code) throws Exception{
        ModelAndView mv = new ModelAndView();
        String checkCode = (String) request.getSession().getAttribute("checkCode");
        unit.setUnitId("44954121");
        unit.setAgentName("李四");
        unit.setPapersName("身份证");
        unit.setPapersNum("129837265427");
        unit.setAgentPhone("1232424");
        unit.setPassword("111111");
        unit.setUnitEmail("123234@123.com");
        unit.setUnitName("alibaba");
        if(/*code.toLowerCase().equals(checkCode.toLowerCase())*/true){
            String message = unitService.login(unit);
            if(message.equals("登录成功")){
                request.getSession().setAttribute("ID",unit.getUnitId());
                request.getSession().setAttribute("name",unit.getAgentName());
                mv.addObject("message",message);
                mv.setViewName("functions");
            }else if(message.equals("登录错误3次，退出系统")){
                mv.addObject("message",message);
                mv.setViewName("test");
            }else {
                mv.addObject("message",message);
                mv.setViewName("test");
            }
        }else {
            mv.addObject("message","验证码输入错误");
            mv.setViewName("test");
        }

        return mv;
    }


}

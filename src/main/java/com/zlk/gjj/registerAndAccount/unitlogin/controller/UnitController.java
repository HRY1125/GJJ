package com.zlk.gjj.registerAndAccount.unitlogin.controller;

import com.zlk.gjj.registerAndAccount.entity.Unit;
import com.zlk.gjj.registerAndAccount.unitlogin.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String singIn(Map<String,Object> map, Unit unit) throws Exception{
        String msg = unitService.insertUnit(unit);
        Unit unitAfter = unitService.findUnitByPapersNum(unit.getPapersNum());
        map.put("message",msg);
        map.put("unit",unitAfter);
        map.put("flag",true);
        return "login";
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
        String vrifyCode = (String) request.getSession().getAttribute("vrifyCode");
        if(vrifyCode.toLowerCase().equals(code.toLowerCase())){
            String message = unitService.login(unit);
            if(message.equals("登录成功")){
                request.getSession().setAttribute("ID",unit.getUnitId());
                request.getSession().setAttribute("name",unit.getAgentName());
                mv.addObject("message",message);
                mv.setViewName("redirect:/sys/toFunctions");
            }else if(message.equals("登录错误3次，退出系统")){
                mv.addObject("message",message);
                mv.setViewName("index");
            }else {
                mv.addObject("message",message);
                mv.setViewName("login");
            }
        }else {
            mv.addObject("message","验证码输入错误");
            mv.setViewName("login");
        }

        return mv;
    }


}

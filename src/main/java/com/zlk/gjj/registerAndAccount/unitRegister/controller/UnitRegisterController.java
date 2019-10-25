package com.zlk.gjj.registerAndAccount.unitRegister.controller;



import com.zlk.gjj.registerAndAccount.entity.Agent;
import com.zlk.gjj.registerAndAccount.entity.Unit;
import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.service.UnitRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.management.counter.Units;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/unitRegister")
public class UnitRegisterController {

    @Autowired
    private UnitRegisterService UnitRegisterService;

    @RequestMapping(value = "/selectUnitRegisterUnitId")
    public String selectUnitRegisterUnitId(UnitRegister unitRegister){
        String s = UnitRegisterService.selectUnitRegisterUnitId(unitRegister);
        System.out.println(s);
        return "test";
    }

    /**
     *  内联检测单位是否已登记
     *@method detection
     *@params [model, unitRegister]
     *@return java.lang.String
     *@author zhang
     *@time 2019/10/23  11:15
     */
    @RequestMapping(value = "/detection",method = RequestMethod.POST)
    public String detection(Model model,UnitRegister unitRegister,HttpServletRequest request) throws Exception{
        String unitName = unitRegister.getUnitName();
        String orgCode = unitRegister.getOrgCode();
//        Map<String,Object> map = new HashMap<>();
//        String unitName = "alibaba";
//        String orgCode = "1";
        if(unitName!=null && !unitName.equals("")){
            UnitRegister unitRegister1 = UnitRegisterService.selectUnitRegisterByName(unitName);
            if(orgCode!=null && !orgCode.equals("")){
                List<String> orgCodes = UnitRegisterService.selectOrgCode();
                Boolean hasCode = orgCodes.contains(orgCode);
                if(hasCode && unitRegister1!=null){
                    model.addAttribute("message","该单位已在系统中登记");
                    model.addAttribute("unitRegister",unitRegister1);
                    return "unit_register_update";
                }else if (hasCode||unitRegister1!=null){
                    model.addAttribute("message","请检查录入信息是否正确");
                    model.addAttribute("unitRegister",unitRegister1);
                    return "unit_register_detection";
                }else {
                    model.addAttribute("message","内联成功，可以登记申请");
                    model.addAttribute("unitRegister",unitRegister);
                    return "unit_register";
                }
            }else {
                if (unitRegister1!=null){
                    model.addAttribute("unitRegister",unitRegister1);
                    return "unit_register_detection";
                }else {
                    model.addAttribute("message","内联成功，可以登记申请");
                    model.addAttribute("unitRegister",unitRegister);
                    return "unit_register";
                }
            }
        }else {
            model.addAttribute("message","单位全称不能为空");
            return "unit_register_detection";
        }
    }

    @RequestMapping(value = "/unitRegister",method = RequestMethod.POST)
    public String unitRegister(Model model,UnitRegister unitRegister,HttpServletRequest request) throws Exception{
        String unitId = (String) request.getSession().getAttribute("ID");
        unitRegister.setUnitId(unitId);
        String message = UnitRegisterService.insertUnitRegister(unitRegister);
        model.addAttribute("message",message);
        return "unit_register_update";
    }

    @RequestMapping(value = "/findUnitRegister")
    public String findUnitRegister(Model model, HttpServletRequest request) throws Exception{
        String unitId = (String) request.getSession().getAttribute("ID");
//        unitId = "1";
        UnitRegister unitRegister = UnitRegisterService.selectUnitRegisterByUId(unitId);
        model.addAttribute("unitRegister",unitRegister);
        return "unit_register_update";
    }

    @RequestMapping(value = "/updateUnitRegister")
    public String updateUnitRegister(Model model,UnitRegister unitRegister) throws Exception{
        Integer integer = UnitRegisterService.updateUnitRegister(unitRegister);
        if (integer>0){
            model.addAttribute("message","修改成功");
            return "unit_register_update";
        }else {
            model.addAttribute("message","修改失败，请重新修改");
            return "unit_register_update";
        }
    }

}

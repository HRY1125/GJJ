package com.zlk.gjj.registerAndAccount.secondAssist.controller;

import com.zlk.gjj.registerAndAccount.entity.PayIn;
import com.zlk.gjj.registerAndAccount.entity.SecondAssist;
import com.zlk.gjj.registerAndAccount.secondAssist.service.SecondAssistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/SecondAssist")
public class SecondAssistController {

    @Autowired
    private SecondAssistService SecondAssistService;


    @RequestMapping(value = "/insertSecondAssist")
    public String insertSecondAssist(SecondAssist secondAssist){
        secondAssist.setSaId("2");
        secondAssist.setUnitId("2");
        secondAssist.setDepartmentCode("2");
        secondAssist.setDepartmentId("2");
        secondAssist.setDepartmentName("2");

        Integer flag = SecondAssistService.insertSecondAssist(secondAssist);
        if(flag == 1){
            return "index1";
        }else {
            return null;
        }
    }

    @RequestMapping(value = "/selectSecondAssistByUnitId")
    public Map selectSecondAssistByUnitId(String unitId){
        List flag= SecondAssistService.selectSecondAssistByUnitId("1");
        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", flag.size());
        map.put("data", flag);
        return map;
    }

    @RequestMapping(value = "/updateSecondAssistById")
    public String updateSecondAssistById( SecondAssist secondAssist){
        secondAssist.setUnitId("1");
        secondAssist.setDepartmentCode("3");
        /*secondAssist.setSaId("4");
        secondAssist.setDepartmentId("4");
        secondAssist.setDepartmentName("4");*/
        Integer flag = SecondAssistService.updateSecondAssistById(secondAssist);
        if(flag == 1){
            return "index1";
        }else {
            return null;
        }
    }

    @RequestMapping(value = "/deleteSecondAssistByUnitId")
    public String deleteSecondAssistByUnitId(String unitId) throws  Exception{

        Integer flag = SecondAssistService.deleteSecondAssistByUnitId("1");
        if(flag == 1){
            return "index1";
        }else {
            return null;
        }
    }

}

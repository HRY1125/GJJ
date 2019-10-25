package com.zlk.gjj.registerAndAccount.secondAssist.controller;

import com.zlk.gjj.registerAndAccount.entity.PayIn;
import com.zlk.gjj.registerAndAccount.entity.SecondAssist;
import com.zlk.gjj.registerAndAccount.secondAssist.service.SecondAssistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
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
    public String selectSecondAssistByUnitId(String unitId){

        List flag= SecondAssistService.selectSecondAssistByUnitId("1");
        if(flag == null){
            return null;
        }else {
            return "index1";
        }

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

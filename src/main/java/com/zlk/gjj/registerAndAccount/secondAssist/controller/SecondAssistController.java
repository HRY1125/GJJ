package com.zlk.gjj.registerAndAccount.secondAssist.controller;

import com.zlk.gjj.registerAndAccount.entity.PayIn;
import com.zlk.gjj.registerAndAccount.entity.SecondAssist;
import com.zlk.gjj.registerAndAccount.secondAssist.service.SecondAssistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/SecondAssist")
public class SecondAssistController {

    @Autowired
    private SecondAssistService SecondAssistService;

    @RequestMapping(value = "/selectSecondAssistByUnitId")
    public Map selectSecondAssistByUnitId(HttpServletRequest request){
        String unitId = (String) request.getSession().getAttribute("ID");
        List res = SecondAssistService.selectSecondAssistByUnitId(unitId);
        Map map = new HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", res.size());
        map.put("data", res);
        return map;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Map insertSecondAssist1(HttpServletRequest request){
        String unitId = (String) request.getSession().getAttribute("ID");
        SecondAssist secondAssist = new SecondAssist();
        secondAssist.setUnitId(unitId);
        Integer flag = SecondAssistService.insertSecondAssist(secondAssist);
        Map map = new HashMap();
        if(flag == 1){
            map.put("retmsg","新增成功");
            return map;
        }else {
            map.put("retmsg","新增失败");
            return map;
        }
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public Map updateSecondAssistById1(@RequestBody SecondAssist secondAssist){
        Integer flag = SecondAssistService.updateSecondAssistById(secondAssist);
        Map map = new HashMap();
        if(flag == 1){
            map.put("retmsg","保存成功");
            return map;
        }else {
            map.put("retmsg","保存失败");
            return map;
        }
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map deleteSecondAssistByUnitId1(@RequestBody SecondAssist secondAssist) throws  Exception{
        Integer flag = SecondAssistService.deleteSecondAssistByUnitId(secondAssist);
        Map map = new HashMap();
        if(flag == 1){
            map.put("retmsg","删除成功");
            return map;
        }else {
            map.put("retmsg","删除失败");
            return map;
        }
    }
}

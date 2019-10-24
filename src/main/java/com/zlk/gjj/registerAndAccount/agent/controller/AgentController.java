package com.zlk.gjj.registerAndAccount.agent.controller;

import com.zlk.gjj.registerAndAccount.agent.service.AgentService;
import com.zlk.gjj.registerAndAccount.entity.Agent;
import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.service.UnitRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: gjj
 * @description: Agent控制器
 * @author: zyx
 * @create: 2019-10-23 20:06
 */
@Controller
@RequestMapping(value = "/agent")
public class AgentController {

    @Autowired
    private AgentService agentService;
    @Autowired
    private UnitRegisterService unitRegisterService;

    @RequestMapping(value = "/toAgent")
    public String toAgent(Model model,String ukey) throws Exception{
        String unitRegisterId = agentService.findUnitRegisterIdByUkey(ukey);
        String unitName = unitRegisterService.selectUnitNameByUnitRegisterId(unitRegisterId);
        model.addAttribute("unitRegisterId",unitRegisterId);
        model.addAttribute("unitName",unitName);
        return "test";
    }

    @RequestMapping(value = "/insertAgent")
    public String insertAgent(Model model, Agent agent) throws Exception{
        String message = agentService.insertAgent(agent);
        model.addAttribute("message","message");
        return "test";
    }

    @RequestMapping(value = "/updateAgent")
    public String updateAgent(Model model,Agent agent) throws Exception{
        String message = agentService.updateAgentById(agent);
        model.addAttribute("message","message");
        return "test";
    }
}

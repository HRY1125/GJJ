package com.zlk.gjj.registerAndAccount.agent.controller;

import com.zlk.gjj.registerAndAccount.agent.service.AgentService;
import com.zlk.gjj.registerAndAccount.entity.Agent;
import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.service.UnitRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String toAgent(Model model, HttpServletRequest request) throws Exception{
//        String unitRegisterId = agentService.findUnitRegisterIdByUkeyOrAgentUserName(agent);
//        String unitName = unitRegisterService.selectUnitNameByUnitRegisterId(unitRegisterId);
//        model.addAttribute("unitRegisterId",unitRegisterId);
//        model.addAttribute("unitName",unitName);
        String unitId = (String) request.getSession().getAttribute("ID");
//        unitId = "24356741";
        Agent agent = agentService.findAgentByUId(unitId);
        model.addAttribute("agent",agent);
        return "agent";
    }

    @RequestMapping(value = "/insertAgent")
    public String insertAgent(Model model, Agent agent) throws Exception{
        String message = agentService.insertAgent(agent);
        model.addAttribute("message","message");
        return "agent";
    }

    @RequestMapping(value = "/updateAgent")
    public String updateAgent(Model model,Agent agent) throws Exception{
        String message = agentService.updateAgentById(agent);
        model.addAttribute("message","message");
        return "agent";
    }
}

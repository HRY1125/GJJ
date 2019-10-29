package com.zlk.gjj.registerAndAccount.sys.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.zlk.gjj.registerAndAccount.entity.Unit;
import com.zlk.gjj.registerAndAccount.account.service.AccountService;
import com.zlk.gjj.registerAndAccount.entity.Account;
import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.mapper.UnitRegisterMapper;
import com.zlk.gjj.registerAndAccount.unitlogin.mapper.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import java.util.Map;

@Controller
@RequestMapping("/sys")
public class SysController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UnitRegisterMapper unitRegisterMapper;
    @Autowired
    private UnitMapper unitMapper;
    @Autowired
    private DefaultKaptcha captchaProducer;


    @RequestMapping("/toFunctions")
    public String toFunctions(HttpServletRequest request,Map map){
        String s = accountService.selectAccountByUnitId((String) request.getSession().getAttribute("ID"));
        map.put("accountKind",s);
        return "functions";
    }

    @RequestMapping("/toUA")
    public String toUA(HttpServletRequest request,Map map){
        String unitId = (String) request.getSession().getAttribute("ID");
        UnitRegister unitRegister = unitRegisterMapper.selectUnitRegisterByUId(unitId);
        if (unitRegister==null){
            map.put("retmsg","单位未登记，请先进行单位登记");
            return "default";
        }
        map.put("unitRegistId",unitRegister.getUnitRegisterId());
        map.put("unitName",unitRegister.getUnitName());
        return "unit_account";
    }

    @RequestMapping("/toPR")
    public String toPR(){
        return "person_regist";
    }

    @RequestMapping("/toPM")
    public String toPM(){
        return "pay_method";
    }

    @RequestMapping("/toRemit")
    public String toRemit(HttpServletRequest request,Map map){
        Account account=accountService.selectAccountByUnitId2((String)request.getSession().getAttribute("ID"));
        if (account==null){
            map.put("retmsg","单位未开户，请先进行单位开户");
            return "default";
        }
        map.put("unitRegistId",account.getUnitRegisterId());
        map.put("unitName",account.getUnitName());
        map.put("source",account.getCapitalSource());
        map.put("unitRatio",account.getUnitDepositeRatio());
        map.put("personRatio",account.getUnitPeopleDepositeRatio());
        return "remit";
    }

    @RequestMapping("/toUR")
    public String toUR(){
        return "unit_register_detection";
    }

    @RequestMapping("/toCard")
    public String toCard() {
        return "card";
    }

    @RequestMapping("/toLogin")
    public String toLogin(Map<String,Object> map){
        Unit unit = new Unit();
        unit.setUnitId("");
        map.put("unit",unit);
        return "login";
    }

    @RequestMapping("/toAgent")
    public String toAgent() {
        return "agent";
    }

    @RequestMapping("/findURId")
    @ResponseBody
    public Map findURId(@RequestBody String URId){
        String unitName = unitRegisterMapper.selectUnitNameByUnitRegisterId(URId);
        Map map = new HashMap();
        map.put("unitName",unitName);
        return map;
    }

    @RequestMapping("/toSA")
    public String toSA() {
        return "second_assist";
    }

    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = captchaProducer.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @RequestMapping("isUnitName")
    @ResponseBody
    public Map isUnitName(@RequestBody String unitName){
        Map map = new HashMap();
        String unitId = unitMapper.findUnitIdByUnitName(unitName);
        if(unitId==null){
            map.put("isExist",false);
        }else{
            map.put("isExist",true);
        }

        return map;
    }

    @RequestMapping("/toDefault")
    public String toDefault(){
        return "default";
    }
}

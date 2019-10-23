package com.zlk.gjj.registerAndAccount.unitRegister.service.impl;

import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.mapper.UnitRegisterMapper;
import com.zlk.gjj.registerAndAccount.unitRegister.service.UnitRegisterService;
import com.zlk.gjj.registerAndAccount.unitlogin.mapper.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitRegisterServiceImpl implements UnitRegisterService {

    @Autowired
    private UnitRegisterMapper UnitRegisterMapper;
    @Autowired
    private UnitMapper unitMapper;

    @Override
    public String selectUnitRegisterUnitId(UnitRegister unitRegister) {
        return UnitRegisterMapper.selectUnitRegisterUnitId(unitRegister);
    }

    @Override
    public UnitRegister selectUnitRegisterByName(String unitName) {
        return UnitRegisterMapper.selectUnitRegisterByName(unitName);
    }

    @Override
    public List<String> selectOrgCode() {
        return UnitRegisterMapper.selectOrgCode();
    }

    @Override
    public String insertUnitRegister(UnitRegister unitRegister) {
        Integer integer = UnitRegisterMapper.insertUnitRegister(unitRegister);
        String message = "";
        if(integer>0){
            message = "单位登记成功";
        }else {
            message = "单位登记失败";
        }
        return message;
    }

    @Override
    public String selectUnitNameByUnitRegisterId(String unitRegisterId) {
        return UnitRegisterMapper.selectUnitNameByUnitRegisterId(unitRegisterId);
    }


}

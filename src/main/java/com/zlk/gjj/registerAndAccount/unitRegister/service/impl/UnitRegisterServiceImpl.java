package com.zlk.gjj.registerAndAccount.unitRegister.service.impl;

import com.zlk.gjj.registerAndAccount.entity.UnitRegister;
import com.zlk.gjj.registerAndAccount.unitRegister.mapper.UnitRegisterMapper;
import com.zlk.gjj.registerAndAccount.unitRegister.service.UnitRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitRegisterServiceImpl implements UnitRegisterService {

    @Autowired
    private UnitRegisterMapper UnitRegisterMapper;

    @Override
    public String selectUnitRegisterUnitId(String unitName, String orgCode) {
        UnitRegister unitRegister = new UnitRegister();
        unitRegister.setUnitName(unitName);
        unitRegister.setOrgCode(orgCode);
        return UnitRegisterMapper.selectUnitRegisterUnitId(unitRegister);
    }


}

package com.zlk.gjj.registerAndAccount.secondAssist.service.impl;

import com.zlk.gjj.registerAndAccount.entity.SecondAssist;
import com.zlk.gjj.registerAndAccount.secondAssist.mapper.SecondAssistMapper;
import com.zlk.gjj.registerAndAccount.secondAssist.service.SecondAssistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondAssistServiceImpl implements SecondAssistService {

    @Autowired
    private SecondAssistMapper SecondAssistMapper;


    @Override
    public Integer insertSecondAssist(SecondAssist secondAssist) {
        return SecondAssistMapper.insertSecondAssist(secondAssist);
    }

    @Override
    public SecondAssist selectSecondAssistByUnitId(String unitId) {
        return SecondAssistMapper.selectSecondAssistByUnitId(unitId);
    }

    @Override
    public Integer updateSecondAssistById(SecondAssist secondAssist) {
        return SecondAssistMapper.updateSecondAssistById(secondAssist);
    }

    @Override
    public Integer deleteSecondAssistByUnitId(String unitId) {
        return SecondAssistMapper.deleteSecondAssistByUnitId(unitId);
    }
}

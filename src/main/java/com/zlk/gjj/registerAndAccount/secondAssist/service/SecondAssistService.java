package com.zlk.gjj.registerAndAccount.secondAssist.service;

import com.zlk.gjj.registerAndAccount.entity.SecondAssist;

import java.util.List;

public interface SecondAssistService {

    Integer insertSecondAssist(SecondAssist secondAssist);

    List selectSecondAssistByUnitId(String unitId);

    Integer updateSecondAssistById(SecondAssist secondAssist);

    Integer deleteSecondAssistByUnitId(SecondAssist secondAssist);
}

package com.zlk.gjj.registerAndAccount.secondAssist.service;

import com.zlk.gjj.registerAndAccount.entity.SecondAssist;

public interface SecondAssistService {

    Integer insertSecondAssist(SecondAssist secondAssist);

    SecondAssist selectSecondAssistByUnitId(String unitId);

    Integer updateSecondAssistById(SecondAssist secondAssist);

    Integer deleteSecondAssistByUnitId(String unitId);
}

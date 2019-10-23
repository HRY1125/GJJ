package com.zlk.gjj.registerAndAccount.secondAssist.mapper;

import com.zlk.gjj.registerAndAccount.entity.SecondAssist;

public interface SecondAssistMapper {

    Integer insertSecondAssist(SecondAssist secondAssist);

    SecondAssist selectSecondAssistByUnitId(String unitId);

    Integer updateSecondAssistById(SecondAssist secondAssist);

    Integer deleteSecondAssistByUnitId(String unitId);
}

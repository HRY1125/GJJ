package com.zlk.gjj.registerAndAccount.secondAssist.mapper;

import com.zlk.gjj.registerAndAccount.entity.SecondAssist;

import java.util.List;

public interface SecondAssistMapper {

    Integer insertSecondAssist(SecondAssist secondAssist);

    List selectSecondAssistByUnitId(String unitId);

    Integer updateSecondAssistById(SecondAssist secondAssist);

    Integer deleteSecondAssistByUnitId(SecondAssist secondAssist);
}

package com.zlk.gjj.registerAndAccount.payIn.service;


import com.zlk.gjj.registerAndAccount.entity.PayIn;

public interface PayInService {
    Integer insertPayIn (PayIn payIn);

    PayIn selectPayInByUnitId(String unitId);

    Integer updatePayInByUnitId(PayIn payIn);
}

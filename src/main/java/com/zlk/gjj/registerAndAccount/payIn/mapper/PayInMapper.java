package com.zlk.gjj.registerAndAccount.payIn.mapper;


import com.zlk.gjj.registerAndAccount.entity.PayIn;

public interface PayInMapper {

    Integer insertPayIn (PayIn PayIn);

    PayIn selectPayInByUnitId(String unitId);

    Integer updatePayInByUnitId(PayIn PayIn);
}

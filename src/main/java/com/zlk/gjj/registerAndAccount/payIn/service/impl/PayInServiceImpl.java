package com.zlk.gjj.registerAndAccount.payIn.service.impl;


import com.zlk.gjj.registerAndAccount.entity.Account;
import com.zlk.gjj.registerAndAccount.entity.PayIn;
import com.zlk.gjj.registerAndAccount.payIn.mapper.PayInMapper;
import com.zlk.gjj.registerAndAccount.payIn.service.PayInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayInServiceImpl implements PayInService {

    @Autowired
    private PayInMapper PayInMapper;



    @Override
    public Integer insertPayIn(PayIn payIn) {

        return PayInMapper.insertPayIn(payIn);
    }

    @Override
    public PayIn selectPayInByUnitId(String unitId) {
        return PayInMapper.selectPayInByUnitId(unitId);

    }

    @Override
    public Integer updatePayInByUnitId(PayIn payIn) {
        return PayInMapper.updatePayInByUnitId(payIn);
    }
}

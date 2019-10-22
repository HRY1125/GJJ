package com.zlk.gjj.registerAndAccount.util;

import java.util.Date;

/**
 * @program: gjj
 * @description: unitId生成工具类
 * @author: zyx
 * @create: 2019-10-22 15:55
 */
public class UnitIdUtil {

    public String getUnitId(){
        long time = new Date().getTime();
        String str = String.valueOf(time);
        String unitId = str.substring(str.length() - 8);
        return unitId;
    }
}

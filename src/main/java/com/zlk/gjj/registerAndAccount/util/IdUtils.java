package com.zlk.gjj.registerAndAccount.util;

import java.util.Date;

public class IdUtils {
    //自动生成Id
    public static String getUnitId(int i){
        long time=new Date().getTime();
        String str=String.valueOf(time);
        String unitId=str.substring(str.length() - i);
        return  unitId;
    }
}

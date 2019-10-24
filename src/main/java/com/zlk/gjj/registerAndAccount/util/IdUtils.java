package com.zlk.gjj.registerAndAccount.util;

import java.util.Date;
import java.util.UUID;

/**
 * @program: gjj
 * @description: unitId生成工具类
 * @author: zyx
 * @create: 2019-10-22 15:55
 */
public class IdUtils {

    /**
     *  根据时间戳生成i位数字id
     *@method getUnitId
     *@params [i]
     *@return java.lang.String
     *@author zhang
     *@time 2019/10/23  17:29
     */
    public static String getUnitId(int i){
        long time = new Date().getTime();
        String str = String.valueOf(time);
        String unitId = str.substring(str.length() - i);
        return unitId;
    }

    /**
     *  生成加密过的UUid
     *@method getUUID
     *@params []
     *@return java.lang.String
     *@author zhang
     *@time 2019/10/23  17:30
     */
    public static String getUUID(){
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        return id;
    }
}

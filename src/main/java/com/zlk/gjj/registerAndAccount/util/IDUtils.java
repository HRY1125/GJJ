package com.zlk.gjj.registerAndAccount.util;

import java.util.UUID;

/**
 * @program: jdbc
 * @description: 随机ID生成器
 * @author: lth
 * @create: 2019-08-05 16:22
 **/
public class IDUtils {

    //生成随机的id
    public static String getUUID(){
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        return id;
    }
}
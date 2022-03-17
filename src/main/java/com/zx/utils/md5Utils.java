package com.zx.utils;

import org.springframework.util.DigestUtils;



public class md5Utils extends DigestUtils {

    //二次封装md5
    public static String MD5(String password) {
        String pwd = null;
        pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        return pwd;
    }
}

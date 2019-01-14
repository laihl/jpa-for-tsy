package com.hailong.jpafortsy.utils;


import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecretUtils {


    public static String encodePwd(String pwd,String secret) throws Exception {

        String encodeStr = pwd+secret;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("加密失败");
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(md5.digest(encodeStr.getBytes()));
    }

    @Test
    public void test() throws Exception {
        String s = encodePwd("teasdasdasdst", "hailong123123123123123");
        System.out.println(s);
    }

}

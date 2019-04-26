package com.zhu.springboot.utils;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/26 15:57
 */
public class StringUtil {
    /**
     * String.format方法：%s相当于占位符
     */
    public static String keyFor(String str) {
        return String.format("account_%s", str);
    }

//    public static void main(String[] args) {
//        String result = keyFor("abc");
//        System.out.println(result);
//    }
}

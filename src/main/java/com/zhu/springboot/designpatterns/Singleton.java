package com.zhu.springboot.designpatterns;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/29 9:06
 */
public class Singleton {
    /**
     * 1、私有无参构造方法，防止直接new对象
     */
    private Singleton() {}

    /**
     * 2、私有静态singleton对象，防止静态调用
     */
    private static Singleton singleton;

    /**
     * 3、加锁获取singleton对象
     * @return Singleton
     */
    public static Singleton getInstance() {
        if (null == singleton) {
            synchronized (Singleton.class) {
                if (null == singleton) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }
}

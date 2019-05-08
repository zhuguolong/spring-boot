package com.zhu.springboot.cglibproxy;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/30 8:47
 */
public class MyHandler implements InvocationHandler {
    private Object target;
    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("-> before");
        return method.invoke(target, objects);
    }
}

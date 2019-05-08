package com.zhu.springboot.cglibproxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/30 8:43
 */
@Component
public class MyPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 返回代理对象
        if ("MyAspectJ".equals(beanName)) {
            return Proxy.newProxyInstance(MyPostProcessor.class.getClassLoader(), new Class[]{MyAspectJ.class}, new MyHandler(bean));
        }
        return bean;
    }
}

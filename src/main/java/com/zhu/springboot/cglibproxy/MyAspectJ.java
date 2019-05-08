package com.zhu.springboot.cglibproxy;

import org.springframework.stereotype.Component;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/30 8:51
 */
@Component
public class MyAspectJ {
    public void myass() {
        System.out.println("-> 日志");
    }
}

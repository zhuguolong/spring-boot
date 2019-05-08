package com.zhu.springboot;

import com.zhu.springboot.service.impl.MathServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void AopTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Application.class);
        // AOP 源码
        MathServiceImpl bean = ac.getBean(MathServiceImpl.class);
        double add = bean.add(11, 12);
        System.out.printf("-----> add result = %s", add);
        System.out.println();
        System.out.printf("-----> %s", bean);
    }

}

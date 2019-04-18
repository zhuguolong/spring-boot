package com.zhu.springboot.aspects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/17 10:09
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    @Bean
    public AopConfig injectAopConfig() {
        return new AopConfig();
    }

    @Bean
    public LogAspects injectLogAspects() {
        return new LogAspects();
    }
}

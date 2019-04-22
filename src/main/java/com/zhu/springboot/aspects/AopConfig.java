package com.zhu.springboot.aspects;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
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

    /**
     * 项目启动时，初始化spring容器，通过
     * {@link EnableAspectJAutoProxy/>注解导入
     * {@link org.springframework.context.annotation.AspectJAutoProxyRegistrar/>类
     * AspectJAutoProxyRegistrar.registerBeanDefinitions() -> AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);
     * 再调用registerOrEscalateApcAsRequired()方法注册或升级需要的Apc，此时会传入{@link AnnotationAwareAspectJAutoProxyCreator}类型
     * {@link AnnotationAwareAspectJAutoProxyCreator/>
     *  -> {@link AspectJAwareAdvisorAutoProxyCreator/>
     *      -> {@link AbstractAdvisorAutoProxyCreator/>.setBeanFactory().initBeanFactory()
     *          -> {@link AbstractAutoProxyCreator/>
     *              implements {@link SmartInstantiationAwareBeanPostProcessor/>, {@link BeanFactoryAware/>
     * {@link SmartInstantiationAwareBeanPostProcessor/>
     *      -> {@link InstantiationAwareBeanPostProcessor/>
     *          -> {@link BeanPostProcessor/>
     *              有两个方法：postProcessBeforeInitialization -> 允许这个后置处理器在任何bean初始化回调之前给定新bean实列（初始化之前调用）
     *                        postProcessAfterInitialization ->允许这个后置处理器在任何bean初始化回调之后给定新bean实列（初始化之后调用）
     * 其中的{@link BeanFactoryAware/>中有方法setBeanFactory()在正常bean属性的群体创建之后、初始化之前回调
     * @return
     */

    @Bean
    public LogAspects injectLogAspects() {
        return new LogAspects();
    }
}

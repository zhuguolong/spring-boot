package com.zhu.springboot.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/18 15:04
 */
@Aspect
public class LogAspects {
    private final Logger log = LoggerFactory.getLogger(LogAspects.class);

    @Pointcut("execution(public * com.zhu.springboot.service.impl.MathServiceImpl.*(..))")
    public void pointCut() {}

    @Before(value = "pointCut()")
    public void aopBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, l = args.length; i < l; i++) {
            if (i < l - 1) {
                sb.append(args[i]).append(", ");
            } else {
                sb.append(args[i]);
            }
        }
        log.info("{}.{}({})", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), sb);
    }

    @After(value = "pointCut()")
    public void aopAfter(JoinPoint joinPoint) {
        String s = joinPoint.getSignature().toShortString();
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void aopAfterThrowing(JoinPoint joinPoint, Exception ex) {
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, l = args.length; i < l; i++) {
            if (i < l - 1) {
                sb.append(args[i]).append(", ");
            } else {
                sb.append(args[i]);
            }
        }
        log.info("{}.{}({}) -> Exception: ", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), sb, ex.getMessage());
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void aopAfterReturning(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, l = args.length; i < l; i++) {
            if (i < l - 1) {
                sb.append(args[i]).append(", ");
            } else {
                sb.append(args[i]);
            }
        }
        log.info("{}.{}({}) -> result: {}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), sb, result);
    }
}

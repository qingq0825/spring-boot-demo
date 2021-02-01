package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Guoqing.Qin
 * @ClassName logAspect
 * @create 2021-01-13 18:23
 * @Description: 打印日志aop切面
 */
@Slf4j
@Aspect
@Component
@SuppressWarnings("ALL")
public class LoggerAspect {
    public LoggerAspect() {
        super();
    }

    @Pointcut("execution(* com.*.controller.*.*(..))")
    private void allMethod() {

    }

    @Before("allMethod()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        log.info("【前置通知】:" + className + "类的" + methodName + "方法开始");
        log.info("【请求报文】:" + Arrays.toString(joinPoint.getArgs()));
    }

    @After("allMethod()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        log.info("【后置通知】: " + className + "类的" + methodName + "方法结束");
    }

    @AfterThrowing(value = "allMethod()", throwing = "except")
    public void afterThrowing(JoinPoint joinPoint, Exception except) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        log.info("【异常通知】: " + className + "类的" + methodName + "方法执行出现异常," + except);
    }

}

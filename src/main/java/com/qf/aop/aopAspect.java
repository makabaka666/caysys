package com.qf.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class aopAspect {
    //声明切点
    @Pointcut("execution(* com.qf.service.impl.*.*(..))")
    public void point(){

    }
    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        Object proceed = null;
        System.out.println("进入了环绕 前置");
        try {
            proceed = joinPoint.proceed();
            System.out.println("进入了环绕 后置");
        } catch (Exception e) {
            //throwable.printStackTrace();
            System.out.println("进入了环绕 异常"+e.getMessage());
            //手动抛出异常，让事务进行控制 并回滚
            throw new Exception("事务回滚 ");
        }finally {
            System.out.println("进入了环绕 最终");
        }
        return proceed;
    }
}

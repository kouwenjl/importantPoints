package com.example.dubbo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class T {
    @Pointcut("execution(public * com.example.dubbo.ApoTestServecie.*(..))")
    public void pointCut(){
    }
    @Before("pointCut()")
    public void f(){
        System.out.println("before");
    }
}

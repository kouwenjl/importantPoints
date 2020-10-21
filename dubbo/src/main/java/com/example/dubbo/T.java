package com.example.dubbo;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class T {
    @Pointcut("execution(public * com.example.dubbo.ApoTestServecie.*(..))")
    public void pointCut(){
    }
    @Around("pointCut()")
    public void f(){
        System.out.println("before");
    }
}

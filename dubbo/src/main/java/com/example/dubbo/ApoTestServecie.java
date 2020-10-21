package com.example.dubbo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ApoTestServecie implements Serializable {
    public void t(){
        System.out.println("aop");
    }
}

package com.example.springcloudclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableCircuitBreaker
public class SpringcloudclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudclientApplication.class, args);
    }
    @RequestMapping("/get8081")
    @HystrixCommand
    public String get8081(String name){
        return "你好:"+name+",这是8081";
    }

}

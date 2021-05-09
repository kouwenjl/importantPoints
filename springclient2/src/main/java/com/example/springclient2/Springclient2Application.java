package com.example.springclient2;


import feign.form.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableZuulProxy
public class Springclient2Application {
    public static void main(String[] args) {
        SpringApplication.run(Springclient2Application.class, args);
    }
//    @Autowired
//    TestFeign testFeign;
//    @RequestMapping("/get8082")
//    @ResponseBody
//    public String get8081() throws Exception{
//        Thread.sleep(5000);
//        return ("8082请求");
//    }

}

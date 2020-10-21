package com.example.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ConfigurationProperties(prefix = "spring.dxs")
@Controller
public class DubboApplication {
    private String dxs;

    public static void main(String[] args) {
        SpringApplication.run(DubboApplication.class, args);
    }

    @Autowired
    ApoTestServecie apoTestServecie;

    @RequestMapping("/test")
    public void test() {
        apoTestServecie.t();
    }

    public String getDxs() {
        return dxs;
    }

    public void setDxs(String dxs) {
        this.dxs = dxs;
    }
}

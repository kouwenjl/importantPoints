package com.example.jta;

import org.hibernate.annotations.OnDelete;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class JtaApplication {
    private String dxs;
    public static void main(String[] args) {
        SpringApplication.run(JtaApplication.class, args);
    }

}

package com.example.rabbimq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.DirectMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RabbimqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbimqApplication.class, args);
    }
   @Autowired
    RabbitTemplate rabbitTemplate;
    @RabbitListener
    public void ss(){


    }
}

package com.example;

import com.rabbitmq.client.*;

public class OriginalClient {
    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("192.168.1.102");
        connectionFactory.setPort(5672);
        Connection connection=connectionFactory.newConnection();
        System.out.println(connection);
        Channel channel=connection.createChannel();
        channel.basicQos(1);
        String queueNameAuto=channel.queueDeclare().getQueue();
        channel.exchangeDeclare("d", BuiltinExchangeType.DIRECT);
        channel.queueBind(queueNameAuto,"d","hh");
        DeliverCallback getMessage=(t,v)->{
            System.out.println("客户端标识:"+t);
            System.out.println("收到的消息:"+new String(v.getBody(),"utf-8"));
            channel.basicAck(v.getEnvelope().getDeliveryTag(),false);
        };
        channel.basicConsume(queueNameAuto,true,getMessage,(v)->{
            System.out.println("取消:"+v);
        });

    }
}

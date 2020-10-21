package com.example;

import com.rabbitmq.client.*;

public class Original {
    public static void main(String[] args) throws Exception{
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("192.168.1.102");
        connectionFactory.setPort(5672);
        Connection connection=connectionFactory.newConnection();
        System.out.println(connection);
        Channel channel=connection.createChannel();
       // channel.exchangeDeclare("d", BuiltinExchangeType.DIRECT);
        channel.queueDeclare("dxs",false,false,false,null);
        channel.confirmSelect();
        channel.addConfirmListener((s,m)->{
            if(m) {
                System.out.println("是否批量确认：" + m);
                System.out.println("确认序号：" + s);
            }
        },(s,m)->{
            System.out.println("是否批量确认失败："+m);
            System.out.println("失败序号："+s);
        });
        int i=0;
        while (i<100000) {
            i++;
            channel.getNextPublishSeqNo();
            String message = "为测试做准备";
            channel.basicPublish("", "dxs",null, message.getBytes());
            // System.out.println("send message success：" + message);
        }
        System.out.println(66);


    }
}

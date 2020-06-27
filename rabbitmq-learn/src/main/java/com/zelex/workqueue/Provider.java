package com.zelex.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zelex.hellorabbitmq.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    public static void main(String[] args) throws IOException {
        //获取连接
        Connection connection = RabbitMQUtils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();

        //通过通道申明队列
        channel.queueDeclare("work",true,false,false,null);

        for (int i=1;i<=20;i++){
            channel.basicPublish("","work",null,(i+"hello,workqueue").getBytes());
        }
        try {
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

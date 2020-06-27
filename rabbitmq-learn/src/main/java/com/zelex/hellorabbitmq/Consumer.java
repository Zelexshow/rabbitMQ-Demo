package com.zelex.hellorabbitmq;


import com.rabbitmq.client.*;
import com.zelex.hellorabbitmq.utils.RabbitMQUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        //获取连接中的通道
        Channel channel = connection.createChannel();

        channel.queueDeclare("hellousr",false,false,false,null);
        //消费消息
        //参数1：消费那个队列的消息 队列名称
        //参数2：开始消费时的自动确认机制
        //参数3：消费时的回调接口
        channel.basicConsume("hellousr",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumeTag, Envelope envelope,AMQP.BasicProperties properties,byte[] body){
                System.out.println("new String(body)= "+new String(body));
            }
        });

        /*channel.close();
        connection.close();*/
    }

}

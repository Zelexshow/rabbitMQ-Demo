package com.zelex.workqueue;

import com.rabbitmq.client.*;
import com.zelex.hellorabbitmq.utils.RabbitMQUtils;

import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws IOException {
        //获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        //获取连接中的通道
        Channel channel = connection.createChannel();
        channel.basicQos(1);//一次只能消费一条信息
        channel.queueDeclare("work",true,false,false,null);
        //消费消息
        //参数1：消费那个队列的消息 队列名称
        //参数2：开始消费时的自动确认机制
        //参数3：消费时的回调接口
        channel.basicConsume("work",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumeTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body){
                System.out.println("消费者2-： "+new String(body));
                try {
                    channel.basicAck(envelope.getDeliveryTag(),false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

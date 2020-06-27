package com.zelex.direct;

import com.rabbitmq.client.*;
import com.zelex.hellorabbitmq.utils.RabbitMQUtils;

import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        //绑定交换机
        channel.exchangeDeclare("logs_direct","direct");

        //临时队列
        String queueName = channel.queueDeclare().getQueue();

        //绑定交换机队列
        channel.queueBind(queueName,"logs_direct","error");
        channel.queueBind(queueName,"logs_direct","info");
        channel.queueBind(queueName,"logs_direct","warning");

        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumeTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body){
                System.out.println("消费者2："+new String(body));
            }
        });
    }
}

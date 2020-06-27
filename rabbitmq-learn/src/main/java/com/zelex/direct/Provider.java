package com.zelex.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zelex.hellorabbitmq.utils.RabbitMQUtils;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs_direct","direct");
        String routingKey="error";
        channel.basicPublish("logs_direct",routingKey,null,"direct type message".getBytes());
        //释放资源
        RabbitMQUtils.closeConnectionAndChannel(connection,channel);
    }
}

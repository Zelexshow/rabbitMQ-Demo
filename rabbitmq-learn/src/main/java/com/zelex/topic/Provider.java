package com.zelex.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zelex.hellorabbitmq.utils.RabbitMQUtils;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topics","topic");
        String routingKey="save.user.delete";
        channel.basicPublish("topics",routingKey,null,("这是topic动态路由模型，routeKey: ["+routingKey+"]").getBytes());
        //释放资源
        RabbitMQUtils.closeConnectionAndChannel(connection,channel);
    }
}

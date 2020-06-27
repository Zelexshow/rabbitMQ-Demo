package com.zelex.fandout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zelex.hellorabbitmq.utils.RabbitMQUtils;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {
        //获取
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        //将通道声明为指定交换机
        //参数1：交换机名称 参数2：交换机类型 fandout
        channel.exchangeDeclare("logs","fanout");

        //发送消息
        channel.basicPublish("logs","",null,"fandout type messange".getBytes());

        //释放资源
        RabbitMQUtils.closeConnectionAndChannel(connection,channel);
    }
}

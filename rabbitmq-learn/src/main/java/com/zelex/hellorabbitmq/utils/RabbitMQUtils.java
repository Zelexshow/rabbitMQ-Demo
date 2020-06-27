package com.zelex.hellorabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class RabbitMQUtils {
    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/test");
        connectionFactory.setUsername("user1");
        connectionFactory.setPassword("user");
    }

    //创建mq的连接工厂对象
    public static Connection getConnection(){
        try {
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭通道和关闭连接工具方法
    public static void closeConnectionAndChannel(Connection connection, Channel channel){
        try {
            if (connection != null) connection.close();
            if (channel != null) channel.close();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}

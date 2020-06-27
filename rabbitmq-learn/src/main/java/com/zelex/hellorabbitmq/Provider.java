package com.zelex.hellorabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.zelex.hellorabbitmq.utils.RabbitMQUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        //获取连接对象
        Connection connection = RabbitMQUtils.getConnection();

        //获取连接中的通道
        Channel channel = connection.createChannel();
        //通道绑定对应消息队列
        //参数1：队列名称 如果队列不存在就自动创建
        //参数2：用来定义队列是否需要持久化 true 持久化 false 不持久化
        //参数3：exclusive 是否独占队列 true独占 false不独占
        //参数4：autoDelete:是否在消费完成后自动删除队列 true 自动删除 false 不自动删除
        //参数5：额外不加消息
        channel.queueDeclare("aa",false,false,false,null);


        //发布消息
        //参数1：交换机名称
        //参数2：队列名称 参数3：传递消息的额外设置 参数4：消息的具体内容
        channel.basicPublish("","aa",null,"hello,rabbitmq".getBytes());

        //调用工具类关闭连接
        RabbitMQUtils.closeConnectionAndChannel(connection,channel);
    }
}

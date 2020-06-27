package com.zelex.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {
    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue,//创建临时队列
            exchange = @Exchange(value = "topics",type = "topic"), //绑定交换机
            key = {"user.*","user.save"}
    ))
    public void receive1(String message){
        System.out.println("message1 = "+message);
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue,//创建临时队列
            exchange = @Exchange(value = "topics",type = "topic"), //绑定交换机
            key = {"#.*","product.#"}
    ))
    public void receive2(String message){
        System.out.println("message2 = "+message);
    }
}

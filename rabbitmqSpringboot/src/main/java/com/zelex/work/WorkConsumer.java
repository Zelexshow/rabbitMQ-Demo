package com.zelex.work;


import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConsumer {

    //注解可以加载方法上，这样一个方法对应一个队列
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive(String message){
        System.out.println("message = "+ message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message){
        System.out.println("message2 = "+ message);
    }
}

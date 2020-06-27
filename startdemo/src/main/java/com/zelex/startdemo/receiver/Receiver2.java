package com.zelex.startdemo.receiver;

import com.zelex.startdemo.sender.Persion;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver2 {

    @RabbitHandler
    @RabbitListener(queues = "hello",containerFactory = "rabbitListenerContainerFactory")
    public void process(String msg){
        System.out.println("Receiver2: "+msg);
    }
}

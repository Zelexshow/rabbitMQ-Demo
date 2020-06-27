package com.zelex.startdemo.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitListener
    public void process(String message){
        System.out.println("Receiver: "+message);
    }
}

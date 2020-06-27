package com.zelex.startdemo.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        for (int i = 0; i <20 ; i++) {
            this.rabbitTemplate.convertAndSend ("hello", "Persion_"+i);
        }
    }
}

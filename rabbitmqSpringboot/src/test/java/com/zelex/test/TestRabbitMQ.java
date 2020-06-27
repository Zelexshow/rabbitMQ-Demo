package com.zelex.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    //hello world
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }
    //work模式
    @Test
    public void testWork(){
        for (int i=0;i<10;i++){//按照均匀分配
            rabbitTemplate.convertAndSend("work","this is testing work--"+i);
        }
    }
    //广播
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","Fanout的模型");
    }

    //route 路由模式
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("directs","info","发送给info的key的路由信息");
    }

    //topic 动态路由 订阅模式
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save 路由信息");
    }

}

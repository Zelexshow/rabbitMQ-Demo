package com.zelex.startdemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class StartdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartdemoApplication.class, args);
	}


}

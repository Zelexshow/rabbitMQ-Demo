package com.zelex.startdemo.controller;

import com.zelex.startdemo.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Sender sender;

    @RequestMapping("/add")
    public String addGuess(){
        sender.send();
        return "ok";
    }
}

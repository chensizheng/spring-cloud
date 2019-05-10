package com.chen.springboothello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @Autowired
    private CounterService counterService;

    @GetMapping("/hello")
    public String hello(){
        counterService.increment("my.hello.count");
        return "hello";
    }
}

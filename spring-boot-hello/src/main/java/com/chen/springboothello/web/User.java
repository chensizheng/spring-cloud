package com.chen.springboothello.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class User {

    @Autowired
    private CounterService counterService;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String hello(){
        counterService.increment("my.hello.count");
        ServiceInstance localServiceInstance = client.getLocalServiceInstance();
        log.info("/hetto,host:"+localServiceInstance.getHost() +", serviceId:"+
                localServiceInstance.getServiceId());
        return "hello";
    }
}

/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package com.chen;

import com.chen.service.HelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/5/14
 */

@RestController
public class FeignController {
    @Autowired
    private HelloService helloService;

    @Autowired
    private HelloFacadeService helloFacadeService;

    @RequestMapping("/feign-consumer")
    private String hello(){
        return helloService.hello();
    }

    @RequestMapping("/feign-facade")
    private String helloFacade(){
        return helloFacadeService.hello("jack");
    }
}
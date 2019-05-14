/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package com.chen.springboothello.web;

import com.chen.service.HelloFacade;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/5/14
 */

@RestController
public class HelloFacadeController implements HelloFacade {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello facade "+name;
    }
}
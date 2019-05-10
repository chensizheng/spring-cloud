/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package com.chen.springboothello;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/5/10
 */
@Component
public class MyMqHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check();

        if(errorCode !=0){
            return Health.down().withDetail("Error code",errorCode).build();
        }
        return Health.up().build();
    }
    private int check(){
        return 404;
    }
}
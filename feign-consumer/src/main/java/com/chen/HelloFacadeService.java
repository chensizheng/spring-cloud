package com.chen;

import com.chen.service.HelloFacade;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/5/14
 */
@FeignClient("hello-service")
public interface HelloFacadeService extends HelloFacade {
}

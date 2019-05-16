package com.chen;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringCloudApplication
@EnableZuulProxy
public class ApiGateWayApplication
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(ApiGateWayApplication.class).web(true).run(args);
    }

    //自定义路由规则
    @Bean
    public PatternServiceRouteMapper patternServiceRouteMapper(){
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>^.+$)",
                "$(version)/$(name)");
    }
}

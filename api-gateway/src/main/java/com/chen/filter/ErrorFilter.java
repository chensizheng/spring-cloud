/*
 * Copyright (c) 2018. 杭州端点网络科技有限公司.  All rights reserved.
 */
package com.chen.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: <a href="sizheng.csz@alibaba-inc.com">XiYing</a>
 * Date: 2019/5/16
 */
@Slf4j
@Component
public class ErrorFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        ctx.set("error.status_code",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.set("error.exception",throwable.getCause());
        /**
         * 或者在pre routing post 过滤器里良好的编码try-cache 到ctx的error.XXX参数中
         * 但这里的不足之处是，从post过滤器抛出的异常，不会再进入SendErrorFilter
         * 所以我们考虑的是再定义一个error过滤器，让它实现SendErrorFilter的功能。
         * extends SendErrorFilter  并保证这个过滤器的执行顺序在SendErrorFilter之后。
         */


        return null;
    }
}
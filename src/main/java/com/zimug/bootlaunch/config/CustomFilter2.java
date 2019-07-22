package com.zimug.bootlaunch.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//注册器名称为customFilter,拦截的url为所有
//@WebFilter(filterName="customFilter",urlPatterns={"/*"})
@Slf4j
public class CustomFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("customFilter2 请求处理之前");
        //对request、response进行一些预处理
        // 比如设置请求编码
        // request.setCharacterEncoding("UTF-8");
        // response.setCharacterEncoding("UTF-8");

        //链路 直接传给下一个过滤器
        chain.doFilter(request, response);

        log.info("customFilter2 请求处理之后");
    }

    @Override
    public void destroy() {
        log.info("filter 销毁");
    }
}
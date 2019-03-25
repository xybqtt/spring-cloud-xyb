package com.xyb.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter {

    @Value("${server:port}")
    private String serverPort;

    // 过滤类型，pre表示在请求之前
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤器的执行顺序，当一个请求在同一个阶段的时候存在多个过滤器，
    // 多个过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 编写过滤器拦截业务逻辑代码
    @Override
    public Object run() throws ZuulException {
        // 案例：拦截所有的服务接口，判断服务接口上是否有传递userToken参数

        // 1、获取上下文
        RequestContext requestContext = RequestContext.getCurrentContext();

        // 2、获取Request
        HttpServletRequest httpServletRequest = requestContext.getRequest();

        // 3、获取token的时候从请求头中获取。
        String userToken = httpServletRequest.getParameter("userToken");
        if(StringUtils.isEmpty(userToken)){
            // 不会继续执行...，不会去调用服务接口，网关服务直接响应给客户端
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody("userToken is null");
            requestContext.setResponseStatusCode(401);
            return null;
        }
        //正常调用其它接口
        System.out.println("网关服务器端口：" + serverPort);
        return null;
    }
}

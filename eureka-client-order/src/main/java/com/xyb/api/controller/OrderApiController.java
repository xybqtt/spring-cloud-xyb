package com.xyb.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderApiController {

    // 是由springbootweb提供的，，默认整合ribbon负载均衡器，底层采用httpclient，注意需要注册，查看启动类
    @Autowired
    private RestTemplate restTemplate;

    // 订单服务调用member模块
    @RequestMapping("/getOrder")
    public String getOrder(){
        // restTemplate有两种调用方式
        // 方法一，直接写好被调用端地址
//        String url = "http://127.0.0.1:8000/getMember";
//        String result = restTemplate.getForObject(url, String.class);

        // 方法二，根据被调用端别名，从eureka获取被调用服务地址，再调用
        String url = "http://member:8000/getMember";
        String result = restTemplate.getForObject(url, String.class);


        System.out.println("会员服务调用订单服务result：" + result);
        return result;
    }
}

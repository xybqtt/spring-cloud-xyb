package com.xyb.api.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {

    @Value("${server.port}")
    private String servicePort;

    @RequestMapping("/getMember")
    public String getOrder(){
        return "this is member，端口号：" + servicePort;
    }
}

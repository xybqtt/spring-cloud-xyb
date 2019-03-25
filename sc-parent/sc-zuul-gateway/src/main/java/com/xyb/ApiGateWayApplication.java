package com.xyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ApiGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApplication.class, args);
    }

    // zuul配置能够使用config实时更新
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }

}

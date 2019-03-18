package com.xyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 开启feign客户端权限
public class EurekaClientOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientOrderApplication.class, args);
    }

    @Bean
    /**
     * 以http://ip:port/getMember调用不需要@LoadBalanced注解
     * 以http://服务别名:port/getMember调用需要添加，且有负载均衡的作用
     */
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

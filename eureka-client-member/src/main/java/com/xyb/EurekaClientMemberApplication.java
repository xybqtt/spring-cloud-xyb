package com.xyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientMemberApplication.class, args);
    }

}

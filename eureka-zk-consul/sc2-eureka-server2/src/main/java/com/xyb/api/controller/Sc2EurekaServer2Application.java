package com.xyb.api.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Sc2EurekaServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sc2EurekaServer2Application.class, args);
    }

}

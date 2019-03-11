package com.xyb.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderApiController {

    @RequestMapping("/getOrder")
    public String getOrder(){
        return "this is order";
    }
}

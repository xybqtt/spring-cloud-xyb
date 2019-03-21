package com.xyb.api.service;

import com.xyb.base.entity.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IOrderService {

    // order调用member
    @RequestMapping("/orderToMember")
    String orderToMember(String name);

    // order调用member
    @RequestMapping("orderToMemberUserInfo")
    ResponseBase orderToMemberUserInfo();


    ResponseBase orderInfo();
}

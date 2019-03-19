package com.xyb.api.service;

import com.xyb.base.entity.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IOrderService {

    // order调用member
    @RequestMapping("/orderToMember")
    public String orderToMember(String name);

    // order调用member
    @RequestMapping("orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo();
}

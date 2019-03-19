package com.xyb.api.service.impl;

import com.xyb.api.entity.UserEntity;
import com.xyb.api.feign.MemberServiceFeign;
import com.xyb.api.service.IOrderService;
import com.xyb.base.entity.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl implements IOrderService {

    // 订单服务继承会员服务接口，用于实现feign客户端，减少重复接口代码
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @RequestMapping("/orderToMember")
    public String orderToMember(String name) {
        UserEntity userEntity = memberServiceFeign.getMember(name);
        return userEntity == null ? "没有找到用户信息" : userEntity.toString();
    }

    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo() {
        return memberServiceFeign.getUserInfo();
    }
}

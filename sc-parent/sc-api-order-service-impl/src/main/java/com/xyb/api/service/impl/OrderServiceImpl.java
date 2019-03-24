package com.xyb.api.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xyb.api.entity.UserEntity;
import com.xyb.api.feign.MemberServiceFeign;
import com.xyb.api.service.IOrderService;
import com.xyb.base.BaseApiService;
import com.xyb.base.entity.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService {

    // 订单服务继承会员服务接口，用于实现feign客户端，减少重复接口代码
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @RequestMapping("/orderToMember")
    public String orderToMember(String name) {
        UserEntity userEntity = memberServiceFeign.getMember(name);
        return userEntity == null ? "没有找到用户信息" : userEntity.toString();
    }

    // 没有解决服务雪崩效应
    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo() {
        return memberServiceFeign.getUserInfo();
    }

    // 订单服务接口
    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo() {
        System.out.println("orderInfo线程池名称：" + Thread.currentThread().getName());
        return setResultSuccess();
    }

    // 解决服务雪崩效应。方法一：线程池隔离，服务降级，服务熔断(全都默认开启)
    // 两种形式：此处为注解形式

    /**
     * 解决服务雪崩效应，使用@HystrixCommand注解
     * @HystrixCommand 注解形式，默认开启线程池隔离、服务降级(降级调用方法fallback)、服务熔断，
     * @return
     * 一个fallback方法只能一个用，这种方法会冗余，所以不建议这么写。而且，会将此方法内的所有代码
     * 重新开个线程池去处理，但是只需要降级的方法去重开线程处理，占用资源多，不推荐。
     */
    @HystrixCommand(fallbackMethod = "orderToMemberUserInfoHystrixFallback")
    @RequestMapping("/orderToMemberUserInfoHystrix")
    public ResponseBase orderToMemberUserInfoHystrix() {
        System.out.println("orderToMemberUserInfoHystrix线程池名称：" + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    public ResponseBase orderToMemberUserInfoHystrixFallback(){
        return setResultSuccess("此处返回一个友好提示，服务降级！");
    }


    /**
     * 解决服务雪崩效应，使用@HystrixCommand注解方法二，更省资源，推荐使用
     */
    @HystrixCommand(fallbackMethod = "orderToMemberUserInfoHystrixFallback")
    @RequestMapping("/orderToMemberUserInfoHystrixDemo2")
    public ResponseBase orderToMemberUserInfoHystrixDemo2() {
        System.out.println("orderToMemberUserInfoHystrix线程池名称：" + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();

    }
}





















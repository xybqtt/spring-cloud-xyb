package com.xyb.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Feign的使用
 * 1、添加依赖、启动类添加注解@EnableFeignClients
 * 2、创建接口
 * 3、接口加注解@FeignClient(name = "要调用的服务名")
 * 4、写对应的方法，@RequestMapping("/xxxx")
 * 5、将此接口注入到要调用的类中，接口.方法即可调用
 */
@FeignClient(name = "member")
public interface MemberApiFeign {

    // 注意添加启动类@EnableFeignClient注解，和将此接口注册到调用类中。
    @RequestMapping("/getMemberByFeign")
    public String getMemberByFeign();

}

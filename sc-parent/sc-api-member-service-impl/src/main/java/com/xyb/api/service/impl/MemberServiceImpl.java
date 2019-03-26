package com.xyb.api.service.impl;

import com.xyb.api.entity.UserEntity;
import com.xyb.api.service.IMemberService;
import com.xyb.base.BaseApiService;
import com.xyb.base.entity.ResponseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("会员服务接口")
public class MemberServiceImpl extends BaseApiService implements IMemberService {

    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(20);
        return userEntity;
    }

    // 从swagger传递参数
    @ApiOperation("获取会员信息")
    @ApiImplicitParam(name = "userName", value = "用户信息参数", required = true, dataType = "String")
    @PostMapping("/getMember2")
    public String getMember2(String userName){
        System.out.println("userName" + userName);
        return "userName：" + userName;
    }

    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo() {
        try {
            // member服务产生1.5秒延迟
            Thread.sleep(1500);
        } catch(Exception e){

        }

        return setResultSuccess("order调用member成功");
    }
}

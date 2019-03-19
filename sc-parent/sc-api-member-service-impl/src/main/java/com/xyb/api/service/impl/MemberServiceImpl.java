package com.xyb.api.service.impl;

import com.xyb.api.entity.UserEntity;
import com.xyb.api.service.IMemberService;
import com.xyb.base.BaseApiService;
import com.xyb.base.entity.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {

    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(20);
        return userEntity;
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

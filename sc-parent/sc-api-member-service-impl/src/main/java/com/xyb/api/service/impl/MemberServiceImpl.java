package com.xyb.api.service.impl;

import com.xyb.api.entity.UserEntity;
import com.xyb.api.service.IMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberServiceImpl implements IMemberService {

    @RequestMapping("/getMember")
    public UserEntity getMember(String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(20);
        return userEntity;
    }
}

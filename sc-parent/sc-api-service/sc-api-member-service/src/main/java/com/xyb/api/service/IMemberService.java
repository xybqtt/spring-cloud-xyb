package com.xyb.api.service;

import com.xyb.api.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IMemberService {

    @RequestMapping("/getMember")
    public UserEntity getMember(String name);

}

package com.xyb.api.fallback;

import com.xyb.api.entity.UserEntity;
import com.xyb.api.feign.MemberServiceFeign;
import com.xyb.base.BaseApiService;
import com.xyb.base.entity.ResponseBase;
import org.springframework.stereotype.Component;

@Component
public class MemerServiceFallback extends BaseApiService implements MemberServiceFeign {
    @Override
    public UserEntity getMember(String name) {
        return null;
    }


    @Override
    public ResponseBase getUserInfo() {
        return setResultError("服务器忙，稍后重试！以类方式启动服务降级");
    }
}

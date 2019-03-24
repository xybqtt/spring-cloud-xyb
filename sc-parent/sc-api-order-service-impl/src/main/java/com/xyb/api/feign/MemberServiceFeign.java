package com.xyb.api.feign;

import com.xyb.api.fallback.MemerServiceFallback;
import com.xyb.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "member", fallback = MemerServiceFallback.class)
public interface MemberServiceFeign extends IMemberService {

}

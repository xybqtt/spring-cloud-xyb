package com.xyb.api.feign;

import com.xyb.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "member")
public interface MemberServiceFeign extends IMemberService {

}

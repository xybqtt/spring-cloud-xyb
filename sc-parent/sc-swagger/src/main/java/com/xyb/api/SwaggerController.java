package com.xyb.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("SwaggerDemo控制器")
@RestController
public class SwaggerController {

    @ApiOperation("swaggerIndex演示接口")
    @GetMapping("/swaggerIndex")
    public String swaggerIndex(){
        System.out.println("swaggerIndex");
        return "swaggerIndex";
    }

    // 从swagger传递参数
    @ApiOperation("获取会员信息")
    @ApiImplicitParam(name = "userName", value = "用户信息参数", required = true, dataType = "String")
    @PostMapping("/getMember")
    public String getMember(String userName){
        System.out.println("userName" + userName);
        return "userName：" + userName;
    }
}

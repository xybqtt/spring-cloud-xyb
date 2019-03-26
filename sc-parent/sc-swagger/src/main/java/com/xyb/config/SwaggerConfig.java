package com.xyb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // 开启swagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                // 生成api扫包范围
                .apis(RequestHandlerSelectors.basePackage("com.xyb.api")).paths(PathSelectors.any()).build();
    }

    // 创建api文档信息
    private ApiInfo apiInfo(){
        // title 文档标题
        // description 文档描述
        return new ApiInfoBuilder().title("标题").description("文档描述")
                .termsOfServiceUrl("http://www.xyb.com")
                // .contact(contact)
                .version("1.0").build();
    }



}

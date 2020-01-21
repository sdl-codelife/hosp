package com.sdl.hosp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**Swagger配置类
 * http://localhost:8787/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.basePackage("com.sdl.hosp"))
                // 扫描指定包中的swagger注解
                //.apis(RequestHandlerSelectors.basePackage("com.fc.test.controller"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置标题
                .title("宠物医院管理系统 API文档")
                //描述
                .description("宠物医院管理系统")
                //作者信息
                //.contact(new Contact(v2Config.getName(), null, V2Config.getEmail_account()))
                //服务条款URL
                .termsOfServiceUrl("www.baidu.com")
                //版本
                .version("版本号:1.0")
                .build();
    }
}

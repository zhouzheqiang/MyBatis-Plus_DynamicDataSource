package com.zzq.pro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2018/5/4.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
     *
     */
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("wang.raye.springboot"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("智科机票内部接口", // 大标题
                "提供内部使用，不对外开发1", // 小标题
                "1.0", // 版本
                "NO terms of service",
                "智科迅优网络技术部", // 作者
                "智科迅优", // 链接显示文字
                ""// 网站链接
        );
        return apiInfo;
    }
}

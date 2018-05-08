package com.zzq.pro;

import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.transaction.annotation.EnableTransactionManagement;
        import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2018/5/4.
 */

@SpringBootApplication
@EnableSwagger2
@Configuration
@ComponentScan("com.zzq.pro")
@EnableTransactionManagement
@MapperScan("com.zzq.pro.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

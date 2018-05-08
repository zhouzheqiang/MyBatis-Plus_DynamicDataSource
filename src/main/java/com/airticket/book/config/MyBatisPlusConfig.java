package com.airticket.book.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableTransactionManagement(order = 2)
@MapperScan({"com.airticket.book.mapper"})
public class MyBatisPlusConfig {

    @Autowired
    private DruidProperties druidProperties;

    @Autowired
    private SlaveDruidProperties slaveDruidProperties;

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    @Profile({"dev"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    private DruidDataSource masterDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidProperties.config( druidDataSource);
        return druidDataSource;
    }

    private DruidDataSource slaveDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        slaveDruidProperties.config( druidDataSource);
        return druidDataSource;
    }

    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map< Object, Object > targetDataSources = new HashMap<>();
        DruidDataSource master = masterDataSource();
        DruidDataSource slave = slaveDataSource();
        try {
            master.init();
            slave.init();
        }catch (SQLException sql){
            sql.printStackTrace();
        }
        targetDataSources.put(DBTypeEnum.MASTER.getValue(), master);
        targetDataSources.put(DBTypeEnum.SLAVE.getValue(), slave);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(master);
        return dynamicDataSource;
    }
}

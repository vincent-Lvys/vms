package com.vincent.microservice.activiti.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class activitiConfig extends AbstractProcessEngineAutoConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.activiti")
    public DataSource activitiDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(PlatformTransactionManager transactionManager, SpringAsyncExecutor springAsyncExecutor) throws IOException {

        return baseSpringProcessEngineConfiguration(
                activitiDataSource(),
                transactionManager,
                springAsyncExecutor);
    }
}

package com.vincent.microservice.activiti;

import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class Application extends AbstractProcessEngineAutoConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}

package com.vincent.microservice.activiti.controller;

import com.vincent.microservice.activiti.service.Impl.ActivitiServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gourd
 */
@RestController
@RequestMapping("/activiti")
@Slf4j
public class ActivitiController {

    @Autowired
    private ActivitiServiceImpl activitiService;


}


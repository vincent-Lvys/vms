package com.vincent.microservice.activiti.controller;

import com.vincent.microservice.activiti.service.Impl.ActivitiServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gourd
 */
@RestController
@RequestMapping("/activiti")
@Slf4j
public class ActivitiController {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private IdentityService identityService;

    @PostMapping("/workflow/{pdKey}")
    public String deployWorkFlow(@PathVariable String pdKey){
        Deployment deploy = repositoryService.createDeployment().addClasspathResource("processes/" + pdKey + ".bpmn").name(pdKey).deploy();
        return deploy.getId();

    }
    @PutMapping("/workflow")
    public String startWorkFlow(){
        String processKey = "QjFlow";
        identityService.setAuthenticatedUserId("001");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey);
        return processInstance.getId()+"<++++++++>"+processInstance.getProcessDefinitionId();
    }




}


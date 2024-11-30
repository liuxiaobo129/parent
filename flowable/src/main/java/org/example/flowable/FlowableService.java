package org.example.flowable;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlowableService {

    private final RepositoryService repositoryService;

    @Autowired
    private TaskService taskService;

    public FlowableService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    public void deployProcessDefinition() {
        repositoryService.createDeployment()
                .addClasspathResource("eave-approval-process.bpmn20.xml")
                .deploy();

        System.out.println("流程定义已成功部署！");

//        IOException
    }


    @Autowired
    private RuntimeService runtimeService;

    public void startProcess() {
        // 启动流程实例
        Map<String, Object> variables = new HashMap<>();
        variables.put("approvalStatus", "approved");

//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leaveRequest1",variables);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("parallelExample",variables);
        System.out.println("Process instance started with ID: " + processInstance.getId());
    }






    public void completeTask(String id) {
        // 查询待办任务
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(id).list();

        if (tasks.size() > 0) {
            // 完成任务
            taskService.complete(tasks.get(0).getId());
            System.out.println("Task completed.");
        }
    }


    public void suspendProcess() {
        // 挂起流程实例
        runtimeService.suspendProcessInstanceById("82501");

        // 激活流程实例
//        runtimeService.activateProcessInstanceById(processInstanceId);
    }


    public void activateProcess() {
        // 挂起流程实例


        // 激活流程实例
        runtimeService.activateProcessInstanceById("82501");
    }
}
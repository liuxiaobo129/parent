package org.example.flowable;



import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


public class MyJavaDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
//        AgendaSessionFactory ;
        System.out.println("Executing Java code in service task");
        // 业务逻辑
        String input = (String) execution.getVariable("inputVariable");
        execution.setVariable("outputVariable", input.toUpperCase());

    }
}
package org.example.feign;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

// 假设这是一个要创建BeanDefinition的类
 class MyBean {
    private String message;

    public MyBean(String message) {
        this.message = message;
    }

    public boolean printMessage() {
        System.out.println(message);
        return false;
    }
}


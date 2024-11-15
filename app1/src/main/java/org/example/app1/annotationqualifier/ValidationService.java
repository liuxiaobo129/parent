package org.example.app1.annotationqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {
//
//    @LoadBalanced
//    @Autowired(required = false)
//    private List<Validator> validators;
//    //...使用validators集合进行验证操作
//    public List<Validator> getValidators() {
//        return validators;
//    }
}
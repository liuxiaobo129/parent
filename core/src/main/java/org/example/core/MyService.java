package org.example.core;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
public class MyService {

    private  DataSource dataSource;

    MyService(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Transactional
    public void sayHello(){
        System.out.println("hello");
    }

}

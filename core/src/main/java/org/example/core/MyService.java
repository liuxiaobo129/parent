package org.example.core;

import javax.sql.DataSource;

public class MyService {

    private  DataSource dataSource;

    MyService(DataSource dataSource){
        this.dataSource = dataSource;
    }

}

//package org.example.app1.test;
//
//package com.msxf.icc2.tenant.service;
//
//import com.msxf.icc2.tenant.api.domain.TenantDept;
//import com.msxf.icc2.tenant.service.mapper.TenantDeptMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author xiaobo.liu
// * @date 2025/2/7
// */
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {ICC2TenantApplication.class, TestMyBatisConfig.class})
//public class UserServiceTest {
//
//    @Autowired
//    private TenantDeptMapper tenantDeptMapper;
//
//    @Test
//    @Sql(scripts = "classpath:sql/tenant_dept.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//    public void testSelectUserById() {
//        // 插入测试数据到H2数据库（如果需要）
//        System.out.println("1111");
//        TenantDept tenantDept = tenantDeptMapper.selectTenantDeptById(1L);
//
//        System.out.println("222");
//    }
//}
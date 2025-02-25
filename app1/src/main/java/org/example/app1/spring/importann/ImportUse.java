package org.example.app1.spring.importann;


import org.springframework.context.ApplicationContext;

public class ImportUse {

//    1. Spring 的默认包路径扫描行为
//
//    Spring 的默认包扫描仅针对用户定义的类路径，比如你应用启动类所在的包及其子包。Spring 的内部类（如 ProxyTransactionManagementConfiguration）
//    通常不会自动被用户应用的扫描路径加载。这也是为了避免加载无关配置或类，保持用户代码的控制性和简洁性。


//   所以要用到import； @EnableTransactionManagement； 这种方式类似于spring-boot-starter

    ApplicationContext applicationContext;

//    #2 bug

}

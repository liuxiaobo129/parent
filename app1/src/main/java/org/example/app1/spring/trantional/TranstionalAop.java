package org.example.app1.spring.trantional;

public class TranstionalAop {

    public static void main(String[] args) {
        //        AnnotationAwareAspectJAutoProxyCreator

        //        InfrastructureAdvisorAutoProxyCreator

//        AopConfigUtils 注册 InfrastructureAdvisorAutoProxyCreator
    }
}


//属性	InfrastructureAdvisorAutoProxyCreator	AnnotationAwareAspectJAutoProxyCreator
//关注点	Spring 的基础设施功能（Advisor）。	基于 AspectJ 注解的切面。
//处理的对象	内置的拦截器（如事务、缓存等）。	用户自定义的 @Aspect 切面类。
//适用场景	自动代理 @Transactional 等基础功能。	处理复杂的自定义切面功能。
//代理创建方式	基于 Spring 内置的 Advisor 实现。	基于 AspectJ 注解规则生成 Advisor。
//底层实现的切面注册逻辑	通过 AbstractAdvisorAutoProxyCreator。	通过扫描 @Aspect 注册切点和增强逻辑。
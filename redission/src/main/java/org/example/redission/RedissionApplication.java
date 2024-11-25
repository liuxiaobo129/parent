package org.example.redission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RedissionApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RedissionApplication.class, args);
        RedissionService bean = (RedissionService)run.getBean("redissionService");

        bean.doSomething();

        System.out.println("end");

    }

}



//分析这个lua脚本的参数：
//
//KEYS[1]：是大key，判断是否有其他线程获取到锁。
//ARGV[1]：锁的释放时间，这个锁如果不释放，多久会超时。
//ARGV[2]：uuid+线程id，用于实现可重入锁。
//分析lua脚本的逻辑：
//        if ((redis.call(‘exists’, KEYS[1]) == 0)or (redis.call(‘hexists’, KEYS[1] ,ARGV[2]) == 1))
//then
//redis.call(‘hincrby’, KEYS[1], ARGV[2], 1);
//redis.call(‘pexpire’, KEYS[1], ARGV[1]);
//return nil;
//end;
//return redis.call(‘pttl’, KEYS[1]);
//
//redis.call(‘exists’, KEYS[1]) == 0：说明大key不存在，也就是没有其他线程获取锁，可以之间获取锁成功了。
//        redis.call(‘hexists’, KEYS[1] ,ARGV[2]) == 1)：redis这大key下，当前线程已经获取到了锁。
//        return redis.call(‘pttl’, KEYS[1])：如果不是上面两种情况，说明其他线程占用锁了，返回这个锁还有多长时间释放。
//        ————————————————
//
//版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
//
//原文链接：https://blog.csdn.net/ludkjava/article/details/141231254
package org.example.redission;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedissionService {

    @Autowired
    private  RedissonClient redissonClient;

    public void doSomething() {
        RLock lock = redissonClient.getLock("myLock");
        try {
            lock.lock();
            // 这里是需要互斥执行的业务逻辑
            System.out.println("获取锁后执行业务逻辑");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("释放锁");
        }
    }
}
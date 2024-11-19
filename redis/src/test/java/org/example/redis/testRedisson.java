package org.example.redis;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import java.util.concurrent.TimeUnit;

class testRedisson {

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void testRedisson() throws Exception{
        //获取锁(可重入)，指定锁的名称
        RLock lock = redissonClient.getLock("anyLock");
        //尝试获取锁，参数分别是：获取锁的最大等待时间(期间会重试)，锁自动释放时间，时间单位
        boolean isLock = lock.tryLock(1,10, TimeUnit.SECONDS);
        //判断获取锁成功
        if(isLock){
            try{
                System.out.println("执行业务");
            }finally{
                //释放锁
                lock.unlock();
            }

        }
    }



}



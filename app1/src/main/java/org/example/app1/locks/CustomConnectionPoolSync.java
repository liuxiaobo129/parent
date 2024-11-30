package org.example.app1.locks;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class CustomConnectionPoolSync extends AbstractQueuedSynchronizer {
    private final int poolSize;
    private int availableConnections;

    public CustomConnectionPoolSync(int poolSize) {
        this.poolSize = poolSize;
        this.availableConnections = poolSize;
    }

    // 尝试获取3个连接
    @Override
    protected int tryAcquireShared(int arg) {
        if (availableConnections >= poolSize / 2 + arg) {
            availableConnections -= arg;
            return arg;
        }
        return -1;
    }

    // 释放3个连接
    @Override
    protected boolean tryReleaseShared(int arg) {
        availableConnections += arg;
        return true;
    }

    // 自定义连接池类，使用上面的同步器
    public static class CustomConnectionPool {
        private final CustomConnectionPoolSync sync;

        public CustomConnectionPool(int poolSize) {
            this.sync = new CustomConnectionPoolSync(poolSize);
        }

        public void acquireConnections() throws InterruptedException {
           sync.acquireSharedInterruptibly(3);
           System.out.println("成功获取3个数据库连接");
        }

        public void releaseConnections() {
            sync.releaseShared(3);
            System.out.println("释放3个数据库连接");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        CustomConnectionPoolSync.CustomConnectionPool pool =
                new CustomConnectionPoolSync.CustomConnectionPool(10);
        // 尝试获取连接
        pool.acquireConnections();
        // 释放连接
        pool.releaseConnections();
    }
}

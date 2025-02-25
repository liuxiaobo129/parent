package org.example.app1.thread;

public class ThreadState {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("end");
            }
        });
        thread1.start();
    }


}


class BlockedThread {
    private final Object lock = new Object();

    public void method1() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is in method1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method2() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " is in method2");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        BlockedThread blockedThread = new BlockedThread();

        Thread thread1 = new Thread(blockedThread::method1, "Thread-1");
        Thread thread2 = new Thread(blockedThread::method2, "Thread-2");

        thread1.start();
        thread2.start();

        Thread.sleep(5000L);

        System.out.println( thread2.getState());
        System.out.println( thread1.getState());
    }

}


class WaitingThread{
    private static final Object lock1 = new Object();
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            synchronized (lock1) {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting");
                    lock1.wait(); // 等待被唤醒
                    System.out.println(Thread.currentThread().getName() + " is resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();



        // 主线程等待一段时间后唤醒
        try {
            Thread.sleep(1000);
            System.out.println(thread.getState());
            synchronized (lock1) {
                lock1.notify();
                System.out.println("Main thread notified");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



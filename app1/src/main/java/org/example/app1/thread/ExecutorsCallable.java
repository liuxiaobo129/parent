package org.example.app1.thread;

import java.util.concurrent.*;

public class ExecutorsCallable {

    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();



        // 创建一个 Callable 实现
        Callable<Integer> task = () -> {
            System.out.println("Task is running...");
            Thread.sleep(20000); // 模拟耗时任务
            return 42; // 返回结果
        };

        // 提交任务并获取 Future 对象
        Future<Integer> future = executorService.submit(task);

        try {
            System.out.println("Waiting for result...");
            // 获取任务结果
            Integer result = future.get();
//            FutureTask
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }


    }
}

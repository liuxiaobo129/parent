package org.example.app1.priority;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class PriorityTask implements Runnable, Comparable<PriorityTask> {
    final int priority;
    private final String name;

    public PriorityTask(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Executing task: " + name + " with priority " + priority);
    }

    @Override
    public int compareTo(PriorityTask other) {
        return Integer.compare(other.priority, this.priority);  // 高优先级排在前
    }
}

public class PriorityTaskExample {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<PriorityTask> queue = new PriorityBlockingQueue<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 添加任务
        queue.add(new PriorityTask(1, "Task A"));
        queue.add(new PriorityTask(1, "Task B"));
        queue.add(new PriorityTask(5, "Task C"));
        queue.add(new PriorityTask(5, "Task D"));
        queue.add(new PriorityTask(10, "Task E"));

        int lastPriority = -1;
        List<PriorityTask> currentBatch = new ArrayList<>();

        while (!queue.isEmpty()) {
            PriorityTask task = queue.poll();
            if (lastPriority == -1 || task.compareTo(new PriorityTask(lastPriority, "")) == 0) {
                currentBatch.add(task);
                lastPriority = task.priority;
            } else {
                executeBatch(executor, currentBatch);  // 执行上一个优先级的任务
                currentBatch.clear();
                currentBatch.add(task);
                lastPriority = task.priority;
            }
        }
        if (!currentBatch.isEmpty()) {
            executeBatch(executor, currentBatch);  // 执行最后一批任务
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    private static void executeBatch(ExecutorService executor, List<PriorityTask> tasks) {
        for (PriorityTask task : tasks) {
            executor.execute(task);
        }
    }
}
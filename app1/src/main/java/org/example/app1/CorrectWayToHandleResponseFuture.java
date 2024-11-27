package org.example.app1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.nio.ByteBuffer;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;


public class CorrectWayToHandleResponseFuture {
    public static void main(String[] args) {
        CompletableFuture<ResponseFuture> future = new CompletableFuture<>();

        // 模拟获取网络请求响应内容的异步操作
        CompletableFuture<String> responseFuture = CompletableFuture.supplyAsync(() -> {
            try {
                // 模拟网络请求延迟
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "这是网络请求的响应内容";
        });

        // 模拟获取状态码的异步操作
        CompletableFuture<Integer> statusCodeFuture = CompletableFuture.supplyAsync(() -> {
            try {
                // 模拟获取状态码的延迟
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 200;
        });

        // 当两个异步操作都完成后，构造ResponseFuture并完成之前创建的CompletableFuture
        CompletableFuture.allOf(responseFuture, statusCodeFuture)
                .thenRun(() -> {
                    try {
                        String response = responseFuture.get();
                        int statusCode = statusCodeFuture.get();
                        ResponseFuture responseFinal = new ResponseFuture(response, statusCode);
                        future.complete(responseFinal);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

    }
}


class ResponseFuture{
    public ResponseFuture(String response, int statusCode) {

    }
}




 class MultipleThenAcceptExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            try {
//                // 模拟异步任务执行时间
//                Thread.sleep(1000);
//                return 42;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                return -1;
//            }
//        });
////        可能第一个thenAccept先执行，也可能第二个thenAccept先执行，这取决于CompletableFuture内部的回调机制和线程调度情况
//        future.thenAccept(result -> System.out.println("第一个thenAccept: " + result));
//        future.thenAccept(result -> System.out.println("第二个thenAccept: " + result));
//
//        future.get();




        CompletableFuture<String> future = new CompletableFuture<>();

        new Thread(() -> {
            try {
                throw new RuntimeException("任务失败");
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }).start();
        future.join();
//        try {
//            System.out.println(future.join()); // 抛出 CompletionException
            future.get();
//        } catch (Exception e) {
//            System.out.println("捕获异常: " + e.getMessage());
//        }
    }
}





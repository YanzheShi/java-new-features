package com.github.yanzheshi.jdk8.thread;

import java.time.Instant;
import java.util.concurrent.*;

/**
 * CompletableFuture 异步编程示例
 * @author shiyanzhe
 * @date 2019/6/4
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception{
        testAsyn();
    }

    /**
     * 异步编程
     * 通过CompletableFuture 的supplyAsync创建一个异步处理流程
     * thenAccept 方法 对返回结果进行异步处理
     * get 阻塞 直到获取结果
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void testAsyn() throws ExecutionException, InterruptedException {

        ThreadFactory threadFactory = Thread::new;

        ExecutorService executorService = new ThreadPoolExecutor(2, 2,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024), threadFactory);

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int[] a = {2};
            return a[2] + "a";
        }, executorService)
            // 出现异常的返回值
            .exceptionally((a)-> "exception occur");

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("任务2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "finish 2" + Instant.now().getEpochSecond();
        }, executorService);

        System.out.println("异步执行中 ..." + Instant.now().getEpochSecond());

        System.out.println("获取结果");

        String result = completableFuture.getNow("unfinish");
        System.out.println("result:" + result);
        // 获取任务1 结果
        completableFuture.thenAccept(s -> System.out.println(s));

        // 获取任务2 结果
        completableFuture2.thenAccept(s -> System.out.println(s));

        System.out.println("get 1: " + completableFuture.get());

        result = completableFuture2.getNow("unfinish");
        System.out.println("result" + result);

        System.out.println("异步执行完成 ..." + Instant.now().getEpochSecond());

    }
}

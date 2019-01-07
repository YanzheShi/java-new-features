package com.github.yanzheshi.jdk7;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

/**
 * fork/join框架
 * JDK自带的并行计算框架
 * 计算List总和
 * @author shiyanzhe
 */
public class ForkJoin extends RecursiveTask<Long> {

    /**
     * 需要求和的列表
     */
    private List<Integer> list;


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoin forkJoin = new ForkJoin();

        int max = 100000000;
        List<Integer> list = new ArrayList<>(max);

        for (int i = 0; i < max; i++) {
            list.add(i);
        }

        forkJoin.setList(list);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //jdk 1.7 fork/join 框架
        System.out.println("使用fork/join框架求和");
        long start = System.currentTimeMillis();
        Future<Long> result = forkJoinPool.submit(forkJoin);
        System.out.println("数组和为：");
        System.out.println(result.get());

        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));

        //普通的循环求和
        System.out.println("普通循环求和");
        start = System.currentTimeMillis();

        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println("数组和为：");
        System.out.println(sum);

        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));



        //jdk 1.8 stream
        System.out.println("使用stream求和");
        start = System.currentTimeMillis();

        sum = list.stream().mapToLong(a->a).reduce(Long::sum).orElse(0);
        System.out.println("数组和为：");
        System.out.println(sum);

        end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));



    }

    @Override
    protected Long compute() {
        long sum = 0;

        Objects.requireNonNull(list);

        int size = list.size();
        if (size == 0) {
            return sum;
        }

        if (size == 1) {
            return sum + list.get(0);
        }

        if (size == 2) {
            return sum + list.get(0) + list.get(1);
        }

        ForkJoin leftTask = new ForkJoin();
        leftTask.setList(list.subList(0, size / 2));

        ForkJoin rightTask = new ForkJoin();
        rightTask.setList(list.subList(size / 2, size));

        leftTask.fork();
        rightTask.fork();

        long leftResult = leftTask.join();
        long rightResult = rightTask.join();

        sum = leftResult + rightResult;

        return sum;
    }


    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}

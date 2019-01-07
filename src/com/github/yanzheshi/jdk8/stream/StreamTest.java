package com.github.yanzheshi.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用steam简化代码
 */
public class StreamTest {
    public static void main(String[] args) {
        //StreamTest.flatMap();

        paralleStream();
    }

    /**
     * 筛选元素
     * 筛选列表里面大于2的元素组成新列表
     */
    public static void filter(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        List<Integer> list = numbers.stream()
                .filter(integer -> integer > 2)
                .collect(Collectors.toList());

        System.out.println(list);
    }

    /**
     * 判断列表里面的所有元素是否都符合要求
     */
    public static void allMatch() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        boolean flag = numbers.stream()
                .allMatch(i -> i > 0);


        System.out.println(flag);
    }

    /**
     * 对所有元素进行转化
     */
    public static void map() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<Integer> list = numbers.stream()
                //每一个元素都乘2
                .map(integer -> integer * 2)
                .collect(Collectors.toList());

        System.out.println(list);
    }


    /**
     * flatMap:将数据扁平化
     * 将包含两个集合的stream转化为包含集合元素的stream
     */
    public static void flatMap() {
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2, 3),
        Arrays.asList(4,5)
        );

        List<Integer> list = stream.flatMap(childList -> childList.stream())
                .collect(Collectors.toList());

        System.out.println(list);
    }

    /**
     * reduce: 对流进行缩减操作
     * 通过reduce求和
     */
    public static void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<Integer> list = numbers.stream()
                                    .reduce(Integer::sum).stream()
                                    .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * reduce: 对流进行缩减操作
     * 通过reduce求和
     */
    public static void reduce1() {
        List<String> a = new ArrayList<>();
        a.add("abc");
        a.add("de");
        a.add("f");

        //第一种方法
        Integer reduce1 = a.stream().map(String::length)
            .reduce(0,Integer::sum);

        System.out.println(reduce1);

        //第二种方法
        Integer reduce2 = a.stream().map(String::length)
            .reduce(Integer::sum).orElse(0);

        System.out.println(reduce2);

    }

    /**
     * 将List 转化为map
     */
    public static void listToMap() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        Map<Integer, Integer> map = numbers.stream().collect(Collectors.toMap(a -> a, a -> a));

        System.out.println(map);
    }

    public static void groupByid() {
        List<Model> models = Arrays.asList(new Model(1, "1"), new Model(2, "2"), new Model(1, "3"));

        Map<Integer, List<Model>> collect = models.stream().collect(Collectors.groupingBy(Model::getId));

        System.out.println(collect);
    }

    /**
     * 从数组中获取流
     */
    public static void getArrayStream() {
        Integer[] array = {1, 2, 3, 4};

        Arrays.stream(array).forEach(item -> System.out.println(item));
    }

    /**
     * 流生成器， 无限流
     */
    public static void infiniteStream() {
        // 生成随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        // Double 类中的toString 方法被重载了， 所以需要使用Object::toString
        //Stream.generate(Math::random).limit(10).map(Double::toString).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).map(Object::toString).forEach(System.out::println);

        // 生成自然数数列
        Stream.iterate(0, a -> ++a).limit(10).forEach(System.out::println);

    }

    /**
     * 并行流， 用于处理数据量达到上万级别的流，否则效率并不比串行流好
     */
    public static void paralleStream() {
        long start = 0;
        Integer result = 0;

        start = System.currentTimeMillis();
        result = Stream.iterate(0, a -> ++a).limit(100).parallel().map(a -> a * 2).reduce(Integer::sum).orElse(
            0);
        System.out.println("parallel 100 time: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        result = Stream.iterate(0, a -> ++a).limit(100).sequential().map(a -> a * 2).reduce(Integer::sum).orElse(
            0);
        System.out.println("serial 100 time: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        result = Stream.iterate(0, a -> ++a).limit(1000).parallel().map(a -> a * 2).reduce(Integer::sum).orElse(
            0);
        System.out.println("parallel 1000 time: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        result = Stream.iterate(0, a -> ++a).limit(1000).sequential().map(a -> a * 2).reduce(Integer::sum).orElse(
            0);
        System.out.println("serial 1000 time: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        result = Stream.iterate(0, a -> ++a).limit(10000).parallel().map(a -> a * 2).reduce(Integer::sum).orElse(
            0);
        System.out.println("parallel 10000 time: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        result = Stream.iterate(0, a -> ++a).limit(10000).sequential().map(a -> a * 2).reduce(Integer::sum).orElse(
            0);
        System.out.println("serial 10000 time: " + (System.currentTimeMillis()-start));


        start = System.currentTimeMillis();
        result = Stream.iterate(0, a -> ++a).limit(100000).parallel().map(a -> a * 2).reduce(Integer::sum).orElse(
            0);
        System.out.println(result);
        System.out.println("parallel 100000 time: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        result = Stream.iterate(0, a -> ++a).limit(100000).sequential().map(a -> a * 2).reduce(Integer::sum).orElse(
            0);
        System.out.println(result);
        System.out.println("serial 100000 time: " + (System.currentTimeMillis()-start));

        Long result1;

        start = System.currentTimeMillis();
        result1 = Stream.iterate(0L, a -> ++a).limit(10000000).parallel().map(a -> a * 2).reduce(Long::sum).orElse(
            0L);
        System.out.println(result1);
        System.out.println("parallel 10000000 time: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        result1 = Stream.iterate(0L, a -> ++a).limit(10000000).sequential().map(a -> a * 2).reduce(Long::sum).orElse(
            0L);
        System.out.println(result1);
        System.out.println("serial 10000000 time: " + (System.currentTimeMillis()-start));
    }

}

package com.github.yanzheshi.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 使用steam简化代码
 */
public class StreamFunctionTest {
    public static void main(String[] args) {
        //StreamFunctionTest.flatMap();

//        paralleStream();

//        reduce();

        groupAndCount();

    }

    /**
     * 筛选元素
     * 筛选列表里面大于2的元素组成新列表
     */
    public static void filter(){

        List<Integer> list = Stream.of(1, 2, 3, 4, 5)
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
        System.out.println(numbers);
        // 返回的集合可以被修改
        list.add(5);
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
        // 处理的结果可以被修改
        list.add(5);
        System.out.println(list);
    }

    /**
     * reduce: 对流进行缩减操作
     * 通过reduce求和
     */
    public static void reduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        Integer sum = numbers.stream()
                                    .reduce(0,Integer::sum);

        System.out.println(sum);
    }

    public static void limitAndSkip(){
        // 对于有序集合，按顺序操作
        System.out.println("Orderly: ");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.stream().skip(2).forEach(System.out::println);
        System.out.println();
        numbers.stream().limit(2).forEach(System.out::println);

        System.out.println("Disorderly: ");
        Set<Object> set = Set.of(1, 2, 3, 4, 5, 6);
        set.stream().skip(2).forEach(System.out::println);
        System.out.println();
        set.stream().limit(2).forEach(System.out::println);
    }

    /**
     * 将List 转化为map
     */
    public static void listToMap() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        Map<Integer, Integer> map = numbers.stream().collect(Collectors.toMap(a -> a, a -> a));

        System.out.println(map);
    }

    /**
     * 按照id分组
     */
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
     * 基本类型转化为包装类
     * boxed
     */
    public static void boxed() {
        int[] num = {1, 2, 3, 4};
        Stream<Integer> boxed = Arrays.stream(num).boxed();
        Stream<Integer> boxed1 = IntStream.of(num).boxed();
    }

    /**
     * 分组统计
     */
    public static void groupAndCount() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4);

        Map<Integer, Long> collect = numbers.stream().collect(Collectors.groupingBy(a -> a, TreeMap::new, Collectors.counting()));

        int[] array = {5, 2, 5, 3, 1, 2, 3, 4, 3, 2, 1};
        // 基本类型数组流要先转化为包装类, 否则无法分组
        Map<Integer, Long> collect1 = Arrays.stream(array).boxed().collect(
            Collectors.groupingBy(a -> a, TreeMap::new, Collectors.counting()));
        System.out.println(collect1);

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
     * 并行流
     * 用于处理数据量达到上万级别的流，否则效率并不比串行流好
     */
    public static void paralleStream() {
        long start = 0;
        Long result;

        start = System.currentTimeMillis();
        result = Stream.iterate(0L, a -> ++a).parallel().map(a -> a * 2).limit(10000000).reduce(0L, Long::sum);
        System.out.println("parallel 100 time: " + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        result = Stream.iterate(0L, a -> ++a).sequential().map(a -> a * 2).limit(10000000).reduce(0L, Long::sum);
        System.out.println("serial 100 time: " + (System.currentTimeMillis()-start));
    }

}

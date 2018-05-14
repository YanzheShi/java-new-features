package com.github.yanzheshi.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用steam简化代码
 */
public class StreamTest {
    public static void main(String[] args) {
        StreamTest.flatMap();
        StreamTest.reduce();
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

}

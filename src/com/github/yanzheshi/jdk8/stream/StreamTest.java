package com.github.yanzheshi.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 使用steam简化代码
 */
public class StreamTest {
    public static void main(String[] args) {
        StreamTest.filter();
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
    public static void he() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        boolean flag = numbers.stream()
                .allMatch(i -> i > 0);


        System.out.println(flag);
    }
}

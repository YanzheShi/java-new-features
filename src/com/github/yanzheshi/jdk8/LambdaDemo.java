package com.github.yanzheshi.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambda表达式示例
 * lambda表达式本身是个语法糖， 用来简化调用函数式接口（只有一个方法的接口）
 */
public class LambdaDemo {
    public static void main(String[] args) {

    }


    /**
     * 使用foreach遍历List
     */
    public static void printListOld() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        for (Integer a: list) {
            System.out.println(a);
        }
    }

    /**
     * 增加了forEach方法，配合lambda表达式遍历数组
     */
    public static void printListNew() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(integer -> System.out.println(integer));
    }

    public static void sortListOld() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                //降序排序
                return (x < y) ? 1 : ((x == y) ? 0 : -1);
            }
        });
    }

    /**
     * 通过lambda表达式对集合排序
     */
    public static void sortListNew() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Collections.sort(list, (x, y) -> {
            //降序排序
            return (x < y) ? 1 : ((x == y) ? 0 : -1);
        });
    }


}

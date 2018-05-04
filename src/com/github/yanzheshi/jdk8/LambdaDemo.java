package com.github.yanzheshi.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * lambda表达式示例
 *
 */
public class LambdaDemo {
    public static void main(String[] args) {

    }

    public static void printListOld() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        for (Integer a: list) {
            System.out.println(a);
        }
    }

    public static void printListNew() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(integer -> System.out.println(integer));
    }
}

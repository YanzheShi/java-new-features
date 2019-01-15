package com.github.yanzheshi.jdk8.lambda;

import java.util.*;

/**
 * lambda表达式示例
 * lambda表达式本身是个语法糖， 用来简化调用函数式接口（只有一个方法的接口）
 * 同时引入的还有一个新的语法符号"::", 可以简化lambda表达式
 * 另外需要注意lambda表达式中的变量不能改变
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
        //遍历数组
        List<Integer> list = Arrays.asList(1, 2, 3);
        //普通对lambda表达式
        list.forEach(integer -> System.out.println(integer));
        //使用方法引用::符号， 简化表达式
        list.forEach(System.out::println);

        //遍历map


        Map<Integer, Integer> map = Map.of(1, 2, 2, 4, 3, 6);

        // 旧的遍历方式
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // 新的遍历方式
        map.forEach((a,b) -> System.out.println(a + " : " + b));
    }

    public static void sortListOld() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        // 降序排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                //降序排序
                //return y-x; // no 可能越界
                //return (x < y) ? 1 : ((x == y) ? 0 : -1);  // ok
                //return  -Integer.compare(x, y);  //ok
                //return Integer.compare(y, x); ok
                //return -x.compareTo(y); // ok
                return y.compareTo(x);
            }
        });
    }

    /**
     * 通过lambda表达式对集合排序
     */
    public static void sortListNew() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        //降序排序
        Collections.sort(list, (x, y) -> y.compareTo(x));
        Collections.sort(list, Comparator.reverseOrder());

        //升序排序
        Collections.sort(list, Integer::compareTo);
        Collections.sort(list);
    }


}

package com.github.yanzheshi.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
//        totalLength();
        testPeek();
    }

    // 统计计算

    /**
     * reduce: 对流进行缩减操作
     * 通过reduce求字符串总长度
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

        //第三种方法
        Integer sum = a.stream().mapToInt(value -> value.length()).sum();
        System.out.println(sum);
    }

    public static void reduce2() {
        List<A> list = new ArrayList<>();
        list.add(A.of(1, 3));
        list.add(A.of(2, 4));
        list.add(A.of(4, 6));
        list.add(A.of(5, 8));
        list.add(A.of(9, 10));
        list.add(A.of(11, 13));


    }

    // 代码复用， 自己编写支持lambda的方法

    /**
     * 代码复用
     * @param stream 传入一个流
     * @param function @FunctionalInterface 相当于可以传入一个lambda表达式
     * @return
     */
    public static Integer getCount(Stream stream, ToIntFunction<String> function){
        return stream.mapToInt(function).sum();
    }

    public static void  totalLength(){
        List<String> a = new ArrayList<>();
        a.add("abc");
        a.add("de");
        a.add("f");
        a.add("G");


        int sum = a.stream().mapToInt(value -> value.length()).sum();
        System.out.println(sum);

        // 计算数组中字符个数
        Integer count = getCount(a.stream(), value -> value.length());
        System.out.println(count);

        // 统计小写字母的个数
        Integer count1 = getCount(a.stream(), value -> (int) value.chars().filter(c -> c >= 97).count());
        System.out.println(count1);
    }

    // 断点调试？

    /**
     * peek方法相当于在流处理中加入了断点，
     */
    public static void testPeek(){
        List<String> a = new ArrayList<>();
        a.add("abc");
        a.add("de");
        a.add("f");
        a.add("G");

        //第二种方法
        Integer reduce = a.stream().map(String::length)
                .peek(System.out::println)
                .reduce(Integer::sum).orElse(0);

        System.out.println(reduce);
    }
}

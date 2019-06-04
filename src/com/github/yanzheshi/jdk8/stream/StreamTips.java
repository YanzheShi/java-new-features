package com.github.yanzheshi.jdk8.stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamTips {
    public static void main(String[] args) {
/*        toStringTest();
        equalTest();
        challengeData();*/

        ArrayList<Object> objects = new ArrayList<>(0);
        objects.add("a");

        System.out.println(objects);
        /*Set<Integer> set1 = new HashSet<>() {};
        Set<Integer> set2 = new HashSet<>() {};
        set1.addAll(Set.of(1, 2, 3, 4));
        set2.addAll(Set.of(2, 3, 4, 5, 6, 7));




        System.out.println(set1.retainAll(set2));
        System.out.println(set1);*/
    }

    public static void toStringTest(){
        // 未重写toString
        System.out.println(Arrays.asList(1, 2, 3, 4).stream().toString());
    }

    public static void equalTest(){
        // 未重写equals
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4);

        System.out.println(Objects.equals(stream1, stream2));
    }

    public static void challengeData() {
        StringBuilder sb = new StringBuilder();

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4);
        stream1.forEach(sb::append);

        System.out.println(sb);
    }
}

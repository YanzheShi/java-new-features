package com.github.yanzheshi.jdk8.stream;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class StreamTips {
    public static void main(String[] args) {
        toStringTest();
        equalTest();
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
}

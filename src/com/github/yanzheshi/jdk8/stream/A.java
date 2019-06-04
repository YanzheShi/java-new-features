package com.github.yanzheshi.jdk8.stream;

/**
 * @author shiyanzhe
 * @date 2019/1/29
 */
public class A {
    int start;
    int end;

    public A(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static A of(int start, int end) {
        return new A(start, end);
    }
}

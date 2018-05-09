package com.github.yanzheshi.jdk8;

/**
 *
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(BB.method());
        System.out.println();
    }
}


class AA {
    public static String method() {
        return "AA";
    }
}

class BB extends AA{

}
package com.github.yanzheshi.jdk7;

import java.math.BigDecimal;

/**
 * switch表达式可以对String类型进行判断
 */
public class SwitchWithString {
    public static void main(String[] args) {

    }

    /**
     * 旧的String 判断需要用if和 equals方法
     * @param s
     */
    public static void old1(String s) {
        if ("one".equals(s)) {
            System.out.println(1);
        } else if ("two".equals(s)) {
            System.out.println(2);
        } else {
            System.out.println("other");
        }
    }

    /**
     * swith对String进行判断
     * @param s
     */
    public static void new1(String s){
        //注意switch需要判空
        if (s == null) {
            System.out.println("other");
        }

        switch (s) {
            case "one":
                System.out.println(1);
                break;
            case "two":
                System.out.println(2);
                break;
            default:
                System.out.println("other");
        }
    }

}

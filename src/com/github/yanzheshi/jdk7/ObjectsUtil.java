package com.github.yanzheshi.jdk7;

import java.util.Objects;

/**
 * Objects工具类
 * 增加了很多实用对方法
 * 这里之展示最常用对 equals方法
 */
public class ObjectsUtil {
    public static void main(String[] args) {

    }

    /**
     * 旧的判等操作
     */
    public static void oldEqual() {
        String a = "a";
        String b = "b";

        if (a != null && a.equals("a")) {
            System.out.println("equal");
        }

        if ("a".equals(a)) {
            System.out.println("equal");
        }

        if (a != null && a.equals(b)) {
            System.out.println("equal");
        }

    }

    /**
     * 新的判等方式
     * 省去了判空步骤
     * 更加简洁与直观
     */
    public static void newEqual() {
        String a = "a";
        String b = "b";

        if (Objects.equals(a, "a")) {
            System.out.println("equal");
        }


        if (Objects.equals(a, b)) {
            System.out.println("equal");
        }
    }
}

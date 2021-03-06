package com.github.yanzheshi.jdk7;

import java.util.Objects;

/**
 * Objects工具类
 * 增加了很多实用对方法
 */
public class ObjectsUtil {
    public static void main(String[] args) {
        ObjectsUtil.deepEquals();
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
        String a = null;
        String b = "b";

        if (Objects.equals(a, "a")) {
            System.out.println("equal");
        }


        if (Objects.equals(a, b)) {
            System.out.println("equal");
        }

    }

    /**
     * 对空引用有了更简单的处理方式
     */
    public static void nullValue() {
        String a = null;

        String notNull;

        //如果为空， 抛空指针异常
        try {
            notNull = Objects.requireNonNull(a);
        } catch (NullPointerException e) {
            System.out.println("NPE");
        }

        //如果为空， 抛空指针异常，并指定异常消息
        try {
            notNull = Objects.requireNonNull(a, "空指针异常");
        } catch (NullPointerException e) {
            System.out.println("NPE");
        }

        //如果为空， 用另一个值代替
        notNull = Objects.requireNonNullElse(a, "b");
        System.out.println(notNull);

    }

    /**
     * deepEquals, 如果是集合说数组，比较各个元素是否相等
     * 否则于Object.equals相同
     */
    public static void deepEquals() {
        int a[] = {1, 2, 3};
        int b[] = {1, 2, 3};

        //直接判断， 返回false
        System.out.println(Objects.equals(a, b));

        //deepEquals返回true
        System.out.println(Objects.deepEquals(a, b));
    }

}

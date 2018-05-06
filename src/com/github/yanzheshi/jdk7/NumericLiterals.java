package com.github.yanzheshi.jdk7;

/**
 * 数值可以使用下划线分隔
 * @author shiyanzhe
 */
public class NumericLiterals {
    public static void main(String[] args) {
        NumericLiterals.numberOld();
        NumericLiterals.numberNew();
    }

    public static void numberOld() {
        int a = 3424323;
        long b = 1231431234;
        double c = 1234.5673;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    /**
     * 数值之间可以用"_"分隔开
     * 下划线对位置可以在数字之间随意放置，但不能放置首和尾
     * 可以帮助快速区分数值
     *
     * 但是在将String转化为数字的时候不支持下划线分割
     *
     */
    public static void numberNew() {
        int a = 342_4323;
        long b = 12_3143_1234;

        System.out.println(a);
        System.out.println(b);


        int c;
        c = 3_424_323;
        long d;
        d = 1_231_431_234;

        System.out.println(c);
        System.out.println(d);


        //nonsupport
        //System.out.println(Integer.valueOf("1_231_431_234"));

        //nonsupport
        //System.out.println(Integer.parseInt("1_231_431_234"));

        double e = 1_234.5673;
        System.out.println(e);
    }
}

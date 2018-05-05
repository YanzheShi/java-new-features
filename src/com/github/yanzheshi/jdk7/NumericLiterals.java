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

        System.out.println(a);
        System.out.println(b);
    }

    /**
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
        System.out.println(Integer.parseInt("1_231_431_234"));

    }
}

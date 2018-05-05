package com.github.yanzheshi.jdk7;

import java.util.ArrayList;
import java.util.List;

/**
 * 钻石表达式
 * 声明一个泛型类型变量， 赋值的时候不需要再次指定泛型类型
 */
public class DiamondSyntax {
    public static void main(String[] args) {

        //旧的声明方式

        List<Integer> a = new ArrayList<Integer>();

        /*------------- */

        //新的声明方式

        List<Integer> b = new ArrayList<>();

        List<Integer> c;
        c = new ArrayList<>();

        List<Integer> d = null;
        d = new ArrayList<>();

    }

}

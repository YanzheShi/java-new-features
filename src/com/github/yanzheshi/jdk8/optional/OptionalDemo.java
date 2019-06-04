package com.github.yanzheshi.jdk8.optional;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.util.Optional.empty;

/**
 * Optional使用示例
 * 为null值对处理提供了一个更优雅对方式
 * 可以不用每时每刻担心空指针
 */
public class OptionalDemo {
    public static void main(String[] args) {
        test();
    }


    /**
     * optional的使用， 可以去掉判空逻辑
     */
    public static void test() {
        String a = null;
        Optional<String> optional = Optional.ofNullable(a);
        System.out.println(optional.isPresent());

        //如果a是null，返回其替代值， 封装了一层判断逻辑
        System.out.println(optional.orElse("empty"));
        System.out.println(optional.or(() -> Optional.of("empty")).get());

        //无需判断a是否是空， 可直接调用方法操作，
        // 如果a是空，map处理返回一个空的Optional， 不会出现异常
        System.out.println(optional.map(string -> string+string).orElse("empty"));

        //进行逻辑判断时，不需要先判断是否微null
        System.out.println(optional.filter(s -> s.compareTo("a") > 0).orElse("empty"));
    }

    public void setValue(Optional<Integer> a, Optional<Integer> b) {
    }
}

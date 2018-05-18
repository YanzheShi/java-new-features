package com.github.yanzheshi.jdk8.annotion;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 注解示例
 */
public class Annotions {
    public static void main(String[] args) {
        Holder<Integer> holder = new @NotEmpty Holder<>();
        @NotEmpty Collection<@NotEmpty String> strings = new ArrayList<>();
    }

    public static class Holder<@NotEmpty T> extends @NotEmpty Object {
        public void method() throws @NotEmpty Exception{

        }
    }
}

package com.github.yanzheshi.jdk8.methodreference;

/**
 * @author shiyanzhe
 */
class Person {
    public String name;

    /**
     * 静态方法
     * 比较两个Person
     * @param a
     * @param b
     * @return 比较结果
     */
    public static int compareByname(Person a, Person b) {
        return a.name.compareTo(b.name);
    }
}

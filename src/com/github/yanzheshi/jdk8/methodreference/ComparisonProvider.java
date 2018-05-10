package com.github.yanzheshi.jdk8.methodreference;

/**
 * 引用该类的方法
 */
class ComparisonProvider {
    public int compareByName(Person a, Person b) {
        return a.name.compareTo(b.name);
    }
}

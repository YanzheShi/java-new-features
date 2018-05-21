package com.github.yanzheshi.jdk9.collectionfactory;

import java.util.*;

/**
 * 使用集合工厂方法， 可以简化集合的初始化
 * 可以替代双括号初始化了
 * 便于直接初始化类对成员变量
 * 需要注意的是，工厂方法返回对是常量
 */
public class CollectionFactory {

    //使用集合工厂方法初始化
    List<Integer> list = List.of(1, 2, 3);
    Set<Integer> set = Set.of(1, 2, 3);
    Map<Integer, Integer> map = Map.of(1, 2);

    //使用双括号初始化
    Map<Integer, Integer> map1 = new HashMap<>(){{
        map1.put(1, 2);
    }};
}

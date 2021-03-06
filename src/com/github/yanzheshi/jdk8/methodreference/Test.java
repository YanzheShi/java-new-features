package com.github.yanzheshi.jdk8.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author shiyanzhe
 */
public class Test {
    public static void main(String[] args) {
        //引用静态方法
        Person a = new Person();
        Person b = new Person();
        a.name = "a";
        b.name = "b";

        //1. 引用静态方法

        System.out.println(Objects.compare(a, b, Person::compareByname));

        //lambda形式
        //System.out.println(Objects.compare(a, b, (o1, o2) -> Person.compareByname(o1, o2)));

        //2. 指向某个对象的实例方法的引用

        ComparisonProvider comparisonProvider = new ComparisonProvider();
        System.out.println(Objects.compare(a, b, comparisonProvider::compareByName));

        //lambda形式
        //System.out.println(Objects.compare(a, b, (o1, o2) -> comparisonProvider.compareByName(o1, o2)));

        //3. 指向某个类型的实例方法的引用
        String string1 = "string1";
        String string2 = "string2";
        System.out.println(Objects.compare(string1, string2, String::compareTo));

        //补充说明：　接口也被当做一种类型， 可以直接用 接口名::方法名 调用实例对象的方法
        List<Type> typeList = new ArrayList<>();
        typeList.add(new TypeImpl());
        typeList.forEach(Type::method);

        List<List> lists = new ArrayList<>();
        lists.forEach(List::toString);

        //lambda形式
        //System.out.println(Objects.compare(string1, string1, (o1, o2)-> o1.compareTo(o2)));


        //4. 指向构造方法的引用

        String[] strings = Stream.of("A", "is", "a", "dog").toArray(String[]::new);

        //lambda形式
        //Stream.of("A", "is", "a", "dog").toArray(value -> new String[value]);

    }
}

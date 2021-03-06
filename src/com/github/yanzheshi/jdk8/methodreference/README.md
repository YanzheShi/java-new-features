#方法引用

方法引用用来简化lambda表达式。 使用方法为 [类名]::[方法名]

使用条件
* lambda表达式的操作为调用某一个方法: (p1, p2, ...) -> method(p1, p2, ...)
* 参数调用顺序要一致
* 不能有歧义，例如方法被重载了，无法决定调用哪一个

方法引用的使用场景有四种：
* 指向静态方法的引用
* 指向某个对象的实例方法的引用
* 指向某个类型的实例方法的引用
* 指向构造方法的引用


##参考文档

[Method References 官方文档](https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html)

[Java 8 方法引用](http://liwenkun.me/2017/03/23/java-8-method-references/)
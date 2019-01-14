# 流（Stream）

## 什么是流？

相当于对数据的一层封装， 通过流对数据封装后， 可以调用流相关的处理方法快速的操作集合。
流的操作都是没有副作用的， 即会生成新对象，而不会修改旧的对象，

## 为什么使用流？

Stream简化了集合的操作。提高了开发的效率。 虽然流式处理性能可能比for循环稍微低一些，但是
编程语言的发展方向是更简洁，更易读，更易编写，所以这些性能上的略微差距可以忽略。

## 什么时候使用？

对集合的操作都可以通过流来进行。

## 常用方法使用说明

- filter: 按条件筛选元素, 返回一个新的流
- allMatch: 判断是否全部符合条件，返回布尔类型
- map: 对所有元素做映射操作, 生成新的流，不会改变原集合的内容
- count: 统计流中元素数量， 返回long类型
- collect: 将流转化为需要的数据结构, 返回具体的数据结构。
- min, max: 找出流中最值, 返回Optional对象
- flatMap: 将多个流连接成一个流, 返回新的流
- reduce: 对流进行缩减操作，即不断地对两个相邻元素进行合并， 最终得到一个结果，
返回optional对象。可以用来求和，求最值等。
- skip: 跳过n个元素, 对于无序集合，取值是不确定的。
- limit: 只取前n个元素, 对于无序集合，取值是不确定的。
- groupBy: 分组. 收集器Collector方法，按照指定条件分组。
 
 
## tips

- stream 未重写toString和equals

## 参考文档

[stream 包官方介绍](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html)

[Java 8 不用再用循环了](http://www.importnew.com/14841.html)

[Stream 原理](https://zhuanlan.zhihu.com/p/31220388)

[Stream 原理深度剖析](https://www.cnblogs.com/Dorae/p/7779246.html)

[Java 8 中的 Streams API 详解](https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/index.html)
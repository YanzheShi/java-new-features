package com.github.yanzheshi.jdk8;

/**
 * 接口方法可以增加默认实现
 * 接口中可以添加静态方法
 */
public interface NewInterface {
    /**
     * 默认方法
     * 实现类可以不覆盖默认方法，使用接口中默认的实现方式
     * @return string
     */
    default String defaultMethod() {
        return "default method";
    }

    /**
     * 接口静态方法
     * @return string
     */
    static String staticMethod(){
        return "static";
    }

}

/**
 * 接口实现类A
 * 实现接口时， 默认方法可以不用覆盖， 调用时执行的是接口中定义的默认实现
 */
class A implements NewInterface {

}


/**
 * 接口实现类B
 * 重写了接口中的默认方法
 */
class B implements NewInterface {
    @Override
    public String defaultMethod() {
        return "B";
    }
}


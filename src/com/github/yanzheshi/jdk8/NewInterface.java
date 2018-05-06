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

class Test {
    public static void main(String[] args) {

        //默认方法测试

        A a = new A();
        B b = new B();

        //调用方法对默认实现
        System.out.println(a.defaultMethod());
        //调用实现类重写的方法
        System.out.println(b.defaultMethod());


        //静态方法测试

        //通过接口名可以直接调用接口静态方法
        System.out.println(NewInterface.staticMethod());

        //但是不支持使用接口显示类对类名直接调用接口静态方法
//        System.out.println(A.staticMethod());   nonsupport
//        System.out.println(B.staticMethod());   nonsupport


        //也不支持使用接口显示类对类名直接调用接口静态方法
//        System.out.println(a.staticMethod());   nonsupport
//        System.out.println(b.staticMethod());   nonsupport

    }
}
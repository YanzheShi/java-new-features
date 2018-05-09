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
        return "B default method";
    }
}

/**
 * 继承接口
 * 可以覆盖父父接口的默认方法
 *
 */
interface Interface2 extends NewInterface {
    /**
     * 继承接口覆盖了父接口的默认方法
     * 默认方法
     * 实现类可以不覆盖默认方法，使用接口中默认的实现方式
     * @return string
     */
    @Override
    default String defaultMethod() {
        return "Interface2 default method";
    }

}

interface Interface3 extends NewInterface {

}

class C implements Interface2 {

}

/**
 * 测试类
 */
class NewInterfaceTest {
    public static void main(String[] args) {

        //接口静态方法

        //只能通过接口名调用接口静态方法
        System.out.println(NewInterface.staticMethod());

        //但是无法通过接口实现类调用接口静态方法
//        System.out.println(A.staticMethod());  nonsupport

        //与类不同， 接口静态方法不会被继承
//        System.out.println(Interface2.staticMethod());  nonsupport


        A a = new A();
        B b = new B();
        C c = new C();

        //接口默认方法测试

        //默认方法可以不用实现类实现，此时调用默认方法实现
        System.out.println(a.defaultMethod());

        //实现类可以覆盖接口默认方法
        System.out.println(b.defaultMethod());

        //子接口也可以覆盖默认方法， 调用对是子接口覆盖后对默认方法
        System.out.println(c.defaultMethod());


    }
}


package com.github.yanzheshi.jdk9.interfaceprivate;

/**
 * 接口可以添加私有方法
 */

public interface NewInterface{

    /**
     * 接口私有方法, 可以被接口默认方法调用
     * @return
     */
    private String privateMethod(){
        return "private method";
    }

    /**
     * 接口默认方法
     * 可以调用接口私有方法
     * @return
     */
    default String defaultMethod() {
        return privateMethod();
    }

}

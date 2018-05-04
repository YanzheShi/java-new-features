package com.github.yanzheshi.jdk7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Scanner;

/**
 * 增强了try-catch语句块
 * try with resource 可以自动关闭流
 * catch 可以同时捕获多个异常
 */
public class TryCatch {
    public static void main(String[] args) {

    }

    public static void tryWithResourceOld() {
        String path = "./TryCatch.java";
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            in.read();
        } catch (Exception e) {
            //do something
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // do something
                }
            }
        }
    }

    /**
     * 新的try with resource
     * 在执行完毕后会自动调用资源对close方法
     */
    public static void tryWithResourceNew() {
        String path = "./TryCatch.java";

        try (InputStream in = new FileInputStream(path)) {
            in.read();
        } catch (Exception e) {
            //do somethinbg
        }

    }


    public static void catchMultipleExceptionOld() {
        try {
            // do something
        } catch (NullPointerException npe) {
            // 处理1
        } catch (IndexOutOfBoundsException ioobe) {
            // 处理1
            System.out.println("运行异常");
        } catch (IllegalArgumentException iae) {
            //处理2
        } catch (IllegalAccessError fnfe) {
            //处理2
        }
    }

    /**
     * 增强catch
     * 一个catch语句可以同时捕获多个异常， 方便对多个异常执行同样的处理
     */
    public static void catchMultipleExceptionNew() {
        try {
            // do something
        } catch (NullPointerException  | IndexOutOfBoundsException e1) {
            // 处理1
        } catch (IllegalArgumentException | IllegalAccessError e2) {
            //处理2
        }
    }


}

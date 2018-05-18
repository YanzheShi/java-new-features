package com.github.yanzheshi.jdk8.annotion;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * 设置注解可放置的位置
 */
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
public @interface NotEmpty {

}

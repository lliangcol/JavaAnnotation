package com.liuliang.demo2;

/*
 * 自定义注解
 * 格式：
 * public @interface 注解名称 {
 * }
 *
 * javac xxx.java
 * javap xxx.class
 * Compiled from "MyAnno.java"
 * public interface MyAnno extends java.lang.annotation.Annotation {
 * }
 * 本质：注解本质上就是一个接口，该接口默认继承 Annotation 接口
 * Annotation 接口：所有注释类型扩展的公共接口；所有注释类型都直接或间接扩展此接口
 *
 */
@CustomAnnotation(max = 10, min = 1, msg = "hello", colour = Colour.RED, subAnnotation = @SubAnnotation("default"), strs = {"a", "b"})
public class Main {
}

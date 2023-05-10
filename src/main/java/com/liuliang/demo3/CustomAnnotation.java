package com.liuliang.demo3;

import com.liuliang.demo2.Colour;
import com.liuliang.demo2.SubAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 自定义注解
 * 格式：
 * public @interface 注解名称 {
 * }
 *
 * 属性：接口中的抽象方法
 * 要求：
 * 1. 属性的返回值类型有下列取值
 *      基本数据类型
 *      String
 *      枚举
 *      注解
 *      以上类型的数组
 * 2. 定义了属性，在使用时需要给属性赋值
 *      1. 如果定义属性时，使用 default 关键字给属性默认初始化值，则使用注解时，可以不进行属性的赋值；
 *      2. 如果只有一个属性需要赋值，且属性的名称是 value，则 value 可以省略，直接定义值即可；
 *      3. 数组赋值时，值使用 {} 包裹。如果数组中只有一个值，则 {} 可以省略；
 * 3. 如果自定义注解没有属性，表明是一个标识作用
 *
 * 元注解：用于描述注解的注解
 * @Target：描述注解能够作用的位置
 *  ElementType 取值：
 *    TYPE：可以作用于类上
 *    METHOD：可以作用于方法上
 *    FIELD：可以作用于成员变量上
 *      ...
 * @Retention：描述注解被保留的阶段
 *  RetentionPolicy 取值：
 *    SOURCE：源码阶段，编译之后，注解被丢弃
 *    CLASS：字节码阶段，编译之后，注解被保留到字节码文件中
 *    RUNTIME：运行阶段，编译之后，注解被保留到字节码文件中，可以被反射机制读取
 * @Documented：描述注解是否被抽取到 api 文档中
 * @Inherited：描述注解是否被子类继承
 */

//@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
//@Retention(value = RetentionPolicy.RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    int max();

    int min();

    String msg();

    Colour colour();

    SubAnnotation subAnnotation();

    String[] strs();
}

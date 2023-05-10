package com.liuliang.demo2;

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
 */
public @interface CustomAnnotation {
    int max();
    int min();
    String msg();
    Colour colour();
    SubAnnotation subAnnotation();
    String[] strs();
}

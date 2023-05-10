package com.liuliang.demo1;

/*
 * 注解（Annotation）也叫元数据。
 * 一种代码级别的说明。
 * 它是JDK1.5及以后版本引入的一个特性，与类、接口、枚举是在同一个层次。
 * 它可以声明在包、类、字段、方法、局部变量、方法参数等的前面，用来对这些元素进行说明，注释。
 *
 * 使用注解：@注解名称
 *
 * 作用分类：
 * 1. 编写文档：通过代码里标识的注解生成文档【生成文档doc文档】
 * 2. 代码分析：通过代码里标识的注解对代码进行分析【使用反射】
 * 3. 编译检查：通过代码里标识的注解让编译器能够实现基本的编译检查【Override】
 *
 * JDK 中预定义的一些注解：
 * @Override：检测被该注解标注的方法是否是继承自父类（接口）的
 * @Deprecated：该注解标注的内容，表示已过时
 * @SuppressWarnings：压制警告
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("liuliang", 18);
        System.out.println(person);
        //person.setName("liu");
        person.setName("liu", "liang");
        System.out.println(person);
    }
}

@SuppressWarnings("all")
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Deprecated
    public void setName(String name) {
        this.name = name;
    }

    public void setName(String firstName, String lastName) {
        this.name = firstName + " " + lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

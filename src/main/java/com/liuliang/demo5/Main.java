package com.liuliang.demo5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

/**
 * Use reflection to test the methods in Math class
 * -----------------------------------------------------------------------
 * 注解给谁用？
 * 1. 给编译器用；
 * 2. 给解析程序用；
 * 3. 给运行时用。
 * -----------------------------------------------------------------------
 * 注解的作用：
 * 1. 标记；
 * 2. 生成文档；
 * 3. 代码分析；
 * 4. 编译检查。
 * -----------------------------------------------------------------------
 * 注解的分类：
 * 1. 按照运行机制分类：
 * 1.1 源码注解：只在源码中存在，编译成.class文件就不存在了；
 * 1.2 编译时注解：在源码和.class文件中都存在，如@Override；
 * 1.3 运行时注解：在运行阶段还起作用，甚至会影响运行逻辑的注解，如@Deprecated。
 * 2. 按照来源分类：
 * 2.1 来自JDK的注解；
 * 2.2 来自第三方的注解；
 * 2.3 自定义注解。
 * -----------------------------------------------------------------------
 * 注解的本质：
 * 本质上是一个接口，继承了Annotation接口。
 * public interface Test extends java.lang.annotation.Annotation {
 * }
 * -----------------------------------------------------------------------
 * 注解的属性：
 * 1. 如果注解有属性，则使用时必须给属性赋值；
 * 2. 如果注解没有属性，则使用时可以不给属性赋值。
 * 注解的属性类型：
 * 1. 八种基本数据类型；
 * 2. String类型；
 * 3. 枚举类型；
 * 4. 注解类型；
 * 5. 以上类型的数组。
 * 注解的属性赋值：
 * 1. 如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可；
 * 2. 数组赋值时，使用{}。
 * -----------------------------------------------------------------------
 * 元注解：
 * 1. @Target：描述注解能够作用的位置；
 * 2. @Retention：描述注解被保留的阶段；
 * 3. @Documented：描述注解是否被抽取到api文档中；
 * 4. @Inherited：描述注解是否被子类继承。
 * -----------------------------------------------------------------------
 * 通过反射获取注解信息：
 * 1. 获取类的注解信息；
 * 2. 获取方法的注解信息；
 * 3. 获取成员变量的注解信息。
 * 通过反射获取注解信息后，可以根据注解信息完成相关的功能。
 * 通过反射获取注解信息后，可以根据注解信息生成相关的配置文件，实现配置文件和代码的分离。
 * 通过反射获取注解信息后，可以根据注解信息生成相关的文档，实现文档和代码的分离。
 * 通过反射获取注解信息后，可以根据注解信息完成一些特殊的操作。
 * -----------------------------------------------------------------------
 * 注解不是程序的一部分，可以理解为注解就是一个标签。
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Class<Math> mathClass = Math.class;
        Math math = mathClass.getDeclaredConstructor().newInstance();
        Method[] methods = mathClass.getMethods();

        int exceptionCount = 0;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method : methods) {
            // 判断方法上是否有Test注解
            if (method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(math, 1, 0);
                } catch (Exception e) {
                    //System.out.println(method.getName() + " failed");
                    exceptionCount++;

                    bufferedWriter.write(method.getName() + " failed");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Caused by: " + e.getCause().getClass().getSimpleName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Caused by: " + e.getCause().getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.write("--------------------------------");
                    bufferedWriter.newLine();
                }
            }
        }

        bufferedWriter.write("There are " + exceptionCount + " exceptions in total");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}

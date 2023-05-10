package com.liuliang.demo4;

@Describe(className = "com.liuliang.demo4.Tank", methodName = "run")
public class Main {
    public static void main(String[] args) {
        // 通过反射获取注解
        // 1.获取该类的字节码文件对象
        // 2.获取上边的注解对象
        // 3.调用注解对象中定义的抽象方法，获取返回值
        // 4.使用类加载器加载该类进内存
        // 5.创建对象
        // 6.获取方法对象
        // 7.执行方法

        Describe describe = Main.class.getAnnotation(Describe.class);
        String className = describe.className();
        String methodName = describe.methodName();
        try {
            Class<?> cls = Class.forName(className);
            //Object obj = cls.newInstance();
            Object obj = cls.getDeclaredConstructor().newInstance();
            cls.getMethod(methodName).invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

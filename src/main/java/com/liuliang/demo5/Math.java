package com.liuliang.demo5;

public class Math {
    @Test
    public int add(int a, int b) {
        return a + b;
    }

    @Test
    public int sub(int a, int b) {
        return a - b;
    }

    @Test
    public int mul(int a, int b) {
        return a * b;
    }

    @Test
    public int div(int a, int b) {
        return a / b;
    }

    public int mod(int a, int b) {
        return a % b;
    }
}

package com.ganzhenghao.innerclass;

/**
 * @ClassName InnerClass
 * @Description 成员内部类
 * @Author Ganzhenghao
 * @Date 2021/2/20 9:40
 * @Version 1.0
 */
public class InnerClass {
    public static void main(String[] args) {

        Inner inner = new InnerClass().new Inner();
        new InnerClass().show();
        inner.show();

    }

    private final int num = 10;

    public void show() {
        System.out.println("this is outer class and num = " + num);
    }

    public class Inner {
        public void show() {
            System.out.println("this is inner class and outer's private num = " + num);
        }
    }

}

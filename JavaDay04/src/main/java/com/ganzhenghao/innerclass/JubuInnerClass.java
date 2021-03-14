package com.ganzhenghao.innerclass;

/**
 * @ClassName JubuInnerClass
 * @Description 局部内部类
 * @Author Ganzhenghao
 * @Date 2021/2/20 10:15
 * @Version 1.0
 */
public class JubuInnerClass {

    public static void main(String[] args) {
        new JubuInnerClass().show();
    }

    public void show() {
        class Inner {
            private int num = 10;

            public void show() {
                System.out.println(num);
            }
        }

        new Inner().show();

    }
}

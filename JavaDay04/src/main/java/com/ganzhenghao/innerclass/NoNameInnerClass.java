package com.ganzhenghao.innerclass;

/**
 * @ClassName NoNameInnerClass
 * @Description 匿名内部类
 * @Author Ganzhenghao
 * @Date 2021/2/20 10:45
 * @Version 1.0
 */
public class NoNameInnerClass {
    public static void main(String[] args) {

        new Inner() {
            @Override
            public void show() {
                System.out.println("Inner interface show()");
            }
        }.show();


        // ((Inner) () -> System.out.println("Inner interface show()")).show();
        new NoNameInnerClass().eat(() -> System.out.println("猫吃鱼"));

        new NoNameInnerClass().eat(new Animal() {
            @Override
            public void eat() {
                System.out.println("狗吃肉");
            }
        });

    }

    public void eat(Animal animal) {
        animal.eat();
    }
}

interface Inner {
    void show();
}

interface Animal {
    void eat();
}
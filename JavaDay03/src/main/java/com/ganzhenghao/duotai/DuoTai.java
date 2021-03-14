package com.ganzhenghao.duotai;

/**
 * @ClassName DuoTai
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/5 15:24
 * @Version 1.0
 */
public class DuoTai {
    public static void main(String[] args) {
        Animal animal = new Cat();
        System.out.println(animal.name);

        animal.method();
        animal.say();
    }

}

class Animal{

    String name = "Animal";

    public void method(){
        System.out.println("This is Animal  -->"+name);
    }

    public void say() {
        System.out.println("hello");
    }

}

class Cat extends Animal{
    String name = "Cat";

    @Override
    public void method() {
        System.out.println("This is Cat  -->"+name);
    }
}

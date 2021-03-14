package com.ganzhenghao.homework.innerclass;

/**
 * @ClassName Out
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/20 18:43
 * @Version 1.0
 */
public class Out {
    public static void main(String[] args){
        fun(new Cat());//请用子类的形式调用
        fun(new Animal() {
            @Override
            public void show() {
                System.out.println("狗吃肉");
            }
        });//请用匿名内部类的形式调用
    }
    public static void fun(Animal a ){
        a.show();
    }

}

interface Animal{
    public void show();
}

class Cat implements Animal{
    @Override
    public void show() {
        System.out.println("猫吃鱼");
    }
}

package com.ganzhenghao.homework.innerclass;

/**
 * @ClassName Outer
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/20 18:40
 * @Version 1.0
 */
public class Outer {
    public void show(){
        int a = 10;
        class Inside{
            public void show(){
                System.out.println("a = " + a);//10
            }
        }
        new Inside().show();
    }

    public static void main(String[] args) {
        new Outer().show();
    }
}

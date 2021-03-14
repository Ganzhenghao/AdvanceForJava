package com.ganzhenghao.innerclass;

/**
 * @ClassName StaticInnerClass
 * @Description 静态成员内部类
 * @Author Ganzhenghao
 * @Date 2021/2/20 10:07
 * @Version 1.0
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        StaticInnerClass.Inner.show();
    }

    static class Inner{
        static void show(){
            System.out.println("Inner Static show()");
        }
    }
}

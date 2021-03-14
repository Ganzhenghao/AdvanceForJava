package com.ganzhenghao.lambda;

/**
 * @ClassName LambdaPracticeOne
 * @Description Lambda表达式 无参数无返回值
 * @Author Ganzhenghao
 * @Date 2021/2/20 13:55
 * @Version 1.0
 */
public class LambdaPracticeOne {

    public static void main(String[] args) {
        new LambdaPracticeOne().show(() -> System.out.println("猫咪展示了他的爪子!"));
    }


    public void show(Animal animal) {
        animal.show();
    }



}

interface Animal{
    void show();
}

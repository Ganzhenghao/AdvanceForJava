package com.ganzhenghao.lambda;

/**
 * @ClassName LambdaPracticeFour
 * @Description 有多个参数 有返回值
 * @Author Ganzhenghao
 * @Date 2021/2/20 15:05
 * @Version 1.0
 */
public class LambdaPracticeFour {
    public static void main(String[] args) {
        new LambdaPracticeFour().sum(((a, b) -> a + b));
    }

    public void sum(SumInter si) {
        System.out.println("si.sum(10, 20) = " + si.sum(10, 20));
    }


}

@FunctionalInterface
interface SumInter {
    int sum(int a, int b);
}
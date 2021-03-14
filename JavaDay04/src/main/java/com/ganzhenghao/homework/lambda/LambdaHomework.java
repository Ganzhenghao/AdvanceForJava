package com.ganzhenghao.homework.lambda;

/**
 * @ClassName LambdaHomework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/20 18:23
 * @Version 1.0
 */
public class LambdaHomework {

    public static void main(String[] args) {
        // TODO 请分别使用Lambda【标准格式】及【省略格式】调用invokeDirect方法
        invokeDirect(() -> {
            System.out.println("导演拍电影了!");
        });
        invokeDirect(() -> System.out.println("导演拍电影了!"));

        invokeCalc(130,120,(int a, int b)->{return a - b;});
        invokeCalc(130,120,(a,b)-> a - b);
    }

    private static void invokeDirect(Director director) {
        director.makeMovie();
    }

    private static void invokeCalc(int a, int b, Calculator calculator) {
        int result = calculator.calc(a, b);
        System.out.println("结果是：" + result);
    }

}

interface Director {
    void makeMovie();
}

interface Calculator {
    int calc(int a, int b);
}
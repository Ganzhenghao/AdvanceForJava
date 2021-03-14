package com.ganzhenghao.lambda;

/**
 * @ClassName Lambda
 * @Description Lambda表达式的省略写法
 * @Author Ganzhenghao
 * @Date 2021/2/20 15:09
 * @Version 1.0
 */
public class Lambda {
    /*
    省略的规则
    - 参数类型可以省略。但是有多个参数的情况下，不能只省略一个
    - 如果参数有且仅有一个，那么小括号可以省略
    - 如果代码块的语句只有一条，可以省略大括号和分号，和return关键字
     */
    public static void main(String[] args) {
        new Lambda().lambdaTest(() -> System.out.println("Lambda 省略格式"));
    }

    public void lambdaTest(LambdaTest lambdaTest) {
        lambdaTest.show();
    }

}

interface LambdaTest {
    void show();
}
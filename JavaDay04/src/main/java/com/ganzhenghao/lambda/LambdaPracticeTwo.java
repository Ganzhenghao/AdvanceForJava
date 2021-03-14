package com.ganzhenghao.lambda;

/**
 * @ClassName LambdaPracticeTwo
 * @Description 有参数无返回值
 * @Author Ganzhenghao
 * @Date 2021/2/20 14:22
 * @Version 1.0
 */
public class LambdaPracticeTwo {

    public static void main(String[] args) {
        new LambdaPracticeTwo().useStringHandler((String message) -> System.out.print(message+"!"));
    }

    public void useStringHandler(StringHandler sh) {
        sh.printMessage("Good Days");
    }

}

interface StringHandler {
    void printMessage(String message);
}

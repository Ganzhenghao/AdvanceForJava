package com.ganzhenghao.lambda;

import java.util.Random;

/**
 * @ClassName LambdaPracticeThree
 * @Description 有参数有返回值
 * @Author Ganzhenghao
 * @Date 2021/2/20 14:31
 * @Version 1.0
 */
public class LambdaPracticeThree {

    public static void main(String[] args) {
        new LambdaPracticeThree().showRandom(
                seek -> new Random().nextInt(seek) + 1
        );
    }

    public void showRandom(RandomHandler randomHandler) {
        System.out.println("randomHandler.getRandom(10) = " + randomHandler.getRandom(10));
    }

}

interface RandomHandler {
    int getRandom(int seek);
}
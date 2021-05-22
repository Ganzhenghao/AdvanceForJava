package com.ganzhenghao;

/**
 * @ClassName Application
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/5/10 18:12
 * @Version 1.0
 */
public class Application {
    public static void main(String[] args) {

        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        threadLocal.set(1);


    }
}

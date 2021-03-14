package com.ganzhenghao.homework.innerclass;

/**
 * @ClassName Outside
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/20 18:37
 * @Version 1.0
 */
public class Outside {
    private final int a = 100;
    class Inside{
        private final int a = 200;
        public void show(){
            int a = 300;
            System.out.println(Outside.this.a);//100
            System.out.println(this.a);//200
            System.out.println(a);//300
        }
    }

    public static void main(String[] args) {
        new Outside().new Inside().show();
    }

}

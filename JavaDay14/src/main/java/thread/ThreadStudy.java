package thread;

/**
 * @ClassName ThreadStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 8:55
 * @Version 1.0
 */
public class ThreadStudy {
    public static void main(String[] args) {
        IceCream iceCream = new IceCream();
        // method1(); 共享变量拷贝机制
        for (int i = 0; i < 10; i++) {
            new Thread(iceCream).start();
        }

    }

    private static void method1() {
        Girl girl = new Girl();
        Boy boy = new Boy();
        girl.setName("Girl");
        boy.setName("Boy");
        girl.start();
        boy.start();
    }
}

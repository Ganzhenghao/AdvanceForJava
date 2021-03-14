package countDownLatch;

import lombok.AllArgsConstructor;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Child
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 18:16
 * @Version 1.0
 */
@AllArgsConstructor
public class Child extends Thread {
    private final CountDownLatch latch;

    @Override
    public void run() {

        for (int i = 1; i < 11; i++) {
            System.out.println(getName()+"吃了第"+i+"个饺子");
        }


        latch.countDown();
    }
}

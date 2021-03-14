package countDownLatch;

import lombok.AllArgsConstructor;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Mother
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 18:15
 * @Version 1.0
 */
@AllArgsConstructor
public class Mother extends Thread{

    private final CountDownLatch latch;

    @Override
    public void run() {

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("妈妈收拾残局");
    }
}

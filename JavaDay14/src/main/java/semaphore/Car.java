package semaphore;

import java.util.concurrent.Semaphore;

/**
 * @ClassName Car
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 18:34
 * @Version 1.0
 */
public class Car implements Runnable{

    private final Semaphore semaphore = new Semaphore(2);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"获得了通行证");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName()+"归还了通行证");
            semaphore.release();
        }

    }
}

package thread.bean;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockThread
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 16:06
 * @Version 1.0
 */
public class LockThread implements Runnable {
    private static Integer ticket = 100;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (ticket > 0) {
            lock.lock();
            try {
                ticket--;
                System.out.println(Thread.currentThread().getName() + "卖了一张票,还剩" + ticket);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

}

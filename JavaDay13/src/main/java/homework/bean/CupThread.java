package homework.bean;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName CupThread
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 18:24
 * @Version 1.0
 */
public class CupThread implements Runnable{

    private int count = 100;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {

        while (true){
            lock.lock();
            try {
                if (count <= 0){break;}
                count--;
                //（实体店卖出第1个，总共剩余n个..）
                System.out.println(Thread.currentThread().getName() + "卖出第"+(100-count)+"个,还剩" + count+"个");
            } finally {
                lock.unlock();
            }
        }

    }
}

package thread.bean;

/**
 * @ClassName Ticket
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 14:17
 * @Version 1.0
 */
public class Ticket implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {

        while (ticket > 0) {
            synchronized (this) {
                ticket--;
                System.out.println(Thread.currentThread().getName() + "卖了一张票,还剩" + ticket);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

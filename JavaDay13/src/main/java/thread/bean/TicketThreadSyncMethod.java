package thread.bean;

/**
 * @ClassName TicketThreadSyncMethod
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 15:35
 * @Version 1.0
 */
public class TicketThreadSyncMethod implements Runnable {
    private static Integer ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            if ("窗口一".equals(Thread.currentThread().getName())) {
                synchronized (this) {
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "卖了一张票,还剩" + ticket);
                }
            }else {
                sale();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void sale() {
        ticket--;
        System.out.println(Thread.currentThread().getName() + "卖了一张票,还剩" + ticket);
    }


}

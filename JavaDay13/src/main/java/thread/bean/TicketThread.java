package thread.bean;

/**
 * @ClassName TicketThread
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 15:11
 * @Version 1.0
 */
public class TicketThread extends Thread{

    private static Integer ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            synchronized (ticket) {
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

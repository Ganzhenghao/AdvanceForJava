package homework.bean;

/**
 * @ClassName TicketThread
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 18:11
 * @Version 1.0
 */
public class TicketThread implements Runnable {

    private int ticket = 100;


    @Override
    public void run() {
/*
        while (ticket > 0) {
            ticket--;
            System.out.println(Thread.currentThread().getName() + "卖了一张,还剩" + ticket);
        }*/

        while (true) {
            if (ticket <= 0) {
                break;
            }
            ticket--;
            System.out.println(Thread.currentThread().getName() + "卖了一张,还剩" + ticket);
        }

    }


}

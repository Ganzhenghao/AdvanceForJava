package homework;

import thread.bean.TicketThread;

/**
 * @ClassName Homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/4 21:01
 * @Version 1.0
 */
public class Homework {

    public static void main(String[] args) {

        //请编写程序，不使用任何同步技术，模拟三个窗口同时卖100张票的情况，
        // 运行并打印结果，观察到错误的数据，并解释出现错误的原因。

        TicketThread ticket = new TicketThread();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
        // 重复票 -> 一个线程在打印结果时被另一个线程抢占CPU 并且运行到了自减代码
        // 负数票-> 理论同上

        //1.2 题目二
        //请使用“同步代码块”改写1.1的程序，保证运行结果的正确。
        /*
                  synchronized (this) {
                ticket--;
                System.out.println(Thread.currentThread().getName()+"卖了一张,还剩"+ticket);
            }
         */
        //1.3 题目三
        //请使用“同步方法”改写1.1的程序，保证运行结果的正确
        /*
        private synchronized void sale(){
        ticket--;
        System.out.println(Thread.currentThread().getName() + "卖了一张,还剩" + ticket);
        }
         */
        //1.4 题目四
        //请使用“Lock锁”改写1.1的程序，保证运行结果的正确
        /*
        private ReentrantLock lock = new ReentrantLock();
            lock.lock();
            ticket--;
            System.out.println(Thread.currentThread().getName() + "卖了一张,还剩" + ticket);
            lock.unlock();
         */


    }



}

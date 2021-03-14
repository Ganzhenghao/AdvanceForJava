package thread;

import thread.bean.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName ThreadStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/4 21:02
 * @Version 1.0
 */
public class ThreadStudy {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //继承Thread
        //method1();

        //实现 Runnable
        //method2();

        //实现Callable<V>
        //method3();

        //Thread.sleep()
        //method4();

        //线程优先级
        //method5();

        //线程安全 Runnable
        //method6();

        //线程安全Thread
        //method7();

        //Sync Method 锁对象是this
        //method8();

        //Lock锁
        //method9();

        //死锁
        //method10();



    }

    private static void method10() {
        Object a = new Object();
        Object b = new Object();

        while (true) {
            new Thread(() -> {
                synchronized (a){
                    synchronized (b){
                        System.out.println("A ---> Go....");
                    }
                }
            }).start();

            new Thread(() -> {
                synchronized (b){
                    synchronized (a){
                        System.out.println("B ---> Go....");
                    }
                }
            }).start();
        }
    }

    private static void method9() {
        LockThread ticket = new LockThread();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t1.start();
        t2.start();
    }

    private static void method8() {
        TicketThreadSyncMethod ticket = new TicketThreadSyncMethod();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t1.start();
        t2.start();
    }

    private static void method7() {
        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        t1.setName("窗口一");
        t2.setName("窗口二");
        t1.start();
        t2.start();
    }

    private static void method6() {
        Ticket ticket = new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();
    }

    private static void method5() {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> stringFutureTask = new FutureTask<>(myCallable);
        FutureTask<String> task = new FutureTask<>(myCallable);
        Thread t1 = new Thread(stringFutureTask);
        t1.setPriority(10);
        Thread t2 = new Thread(task);
        t2.setPriority(1);
        t1.setName("舒克");
        t2.setName("贝塔");
        t1.start();
        t2.start();
    }

    private static void method4() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("每隔0.1秒 输出一次结果: "+ i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void method3() throws InterruptedException, ExecutionException {
        MyCallable myCallable = new MyCallable();
        FutureTask<String> task = new FutureTask<>(myCallable);
        new Thread(task).start();
        System.out.println(task.get());
    }

    private static void method2() {
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
    }

    private static void method1() {
        Thread t1 = new MyThread("ThreadExtends-->1");
        Thread t2 = new MyThread("ThreadExtends-->2");
        t1.start();
        t2.start();
    }


}

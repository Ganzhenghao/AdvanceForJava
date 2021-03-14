package homework;

import java.util.concurrent.*;

/**
 * @ClassName Homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 8:54
 * @Version 1.0
 */
public class Homework {
    public static void main(String[] args) {

        //	请按以下步骤编写程序：
        //	定义一个线程类，实现Callable接口。此线程可以计算1--100的所有数字的累加和。
        //	定义测试类，和main()方法，使用线程池启动线程，并获取计算结果，并将结果打印到控制台。
        //mustOne();

        //	请使用ConcurrentHashMap定义一个线程安全的Map，使用两个线程访问它：
        //	第一个线程：向集合中添加键、值都是：1--10000的数字；
        //	第二个线程：向集合中添加键、值都是：10001--20000的数字；
        //	确保两个线程全部操作集合完毕，然后打印集合的每个元素，测试期准确性。
        //mustTwo();

        //	请使用CountDownLatch编写一个程序，实现以下效果：
        //	线程A打印：”开始计算”
        //	线程B：计算1--100所有数的累加和，并打印结果。
        //	线程A打印：”计算完毕”
        //mustThree();

        //	请使用Semaphore编写一个程序，实现以下效果：
        //	有10名游客要参观展览室，而“展览室”同时只允许最多“三个游客”参观，每个游客参观时间2秒。
        //mustFour();


    }

    private static void mustFour() {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"开始参观了");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+"参观完毕");
                    semaphore.release();
                }
            }).start();
        }
    }

    private static void mustThree() {
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            try {
                System.out.println("开始计算");
                latch.await();
                System.out.println("计算完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            int sum = 0;
            for (int i = 1; i < 101; i++) {
                sum += i;
            }
            System.out.println("1-100的和: "+sum);
            latch.countDown();
        }).start();
    }

    private static void mustTwo() {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();


        new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                map.put(i, i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 10001; i <= 20000; i++) {
                map.put(i, i);
            }
        }).start();

        //map.forEach((integer, integer2) -> System.out.println(integer+"="+integer2));

        for (int i = 1; i <= 20000; i++) {
            System.out.println(i + " = "+ map.get(i));
        }
    }

    private static void mustOne() {
        SumCallable sumCallable = new SumCallable();
        FutureTask<Integer> task = new FutureTask<>(sumCallable);
        new Thread(task).start();
        try {
            System.out.println("task.get() = " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

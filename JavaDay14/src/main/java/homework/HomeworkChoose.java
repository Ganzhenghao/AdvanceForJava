package homework;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;

/**
 * @ClassName HomeworkChoose
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 19:28
 * @Version 1.0
 */
public class HomeworkChoose {
    public static void main(String[] args) {
        //使用线程池,分别开启三条线程,生成10个1到100的随机数,然后计算他们的平均数,
        // 最后计算这三个平均数的平 均数.(使用Callable)
        //mayOne();

        //使用线程池创建多线程。模拟同学找老师学习Java。
        //1. 创建线程池对象，包含2个线程。从线程池中获取线程对象，然后调用MyRunnable中的run()。
        //2. 在MyRunnable实现类中，首先在控制台打印需求，“我需要一个老师”。
        // 模拟需要2秒钟时间老师可以过来指导学生，并在控制台打印老师的姓名。
        // 最后，在控制台打印“教我java,教完后，老师回到了办公室”；

        //mayTwo();


    }

    private static void mayTwo() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        service.submit(() -> {
            System.out.println("我需要一个老师");
            try {
                Thread.sleep(2000);

                System.out.println("教我java,教完后，老师回到了办公室");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                latch.countDown();
                try {
                    latch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        service.submit(() -> {
            try {
                latch.await();
                System.out.println("老师--->王大毛");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                latch2.countDown();
            }
        });

        service.shutdown();
    }

    private static void mayOne() {
        ExecutorService service = Executors.newCachedThreadPool();
        AverageCallable averageCallable = new AverageCallable();
        FutureTask<BigDecimal> task1 = new FutureTask<>(averageCallable);
        FutureTask<BigDecimal> task2 = new FutureTask<>(averageCallable);
        FutureTask<BigDecimal> task3 = new FutureTask<>(averageCallable);

        service.submit(task1);
        service.submit(task2);
        service.submit(task3);

        try {
            BigDecimal avg = (task3.get().add(task1.get().add(task2.get()))).divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
            System.out.println("All--> AVG:"+avg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}

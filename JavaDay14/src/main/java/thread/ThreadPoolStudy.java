package thread;

import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 11:10
 * @Version 1.0
 */
public class ThreadPoolStudy {

    public static void main(String[] args) {
        //method1(); 创建默认线程池
        //method2(); 创建最大数量线程池
        //method3(); 自定义线程池
        //method4(); 拒绝策略


    }

    private static void method4() {
        /*
    ThreadPoolExecutor.AbortPolicy: 		    丢弃任务并抛出RejectedExecutionException异常。是默认的策略。
    ThreadPoolExecutor.DiscardPolicy： 		   丢弃任务，但是不抛出异常 这是不推荐的做法。
    ThreadPoolExecutor.DiscardOldestPolicy：    抛弃队列中等待最久的任务 然后把当前任务加入队列中。
    ThreadPoolExecutor.CallerRunsPolicy:        调用任务的run()方法绕过线程池直接执行。
    */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                2, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        pool(threadPoolExecutor);
    }

    private static void method3() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        pool(threadPoolExecutor);
    }

    private static void method2() {
        pool(Executors.newFixedThreadPool(10));
    }

    private static void method1() {
        pool(Executors.newCachedThreadPool());
    }

    private static void pool(ExecutorService executorService) {
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));
/*        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));
        executorService.submit(() -> System.out.println(Thread.currentThread().getName() + "执行了"));
        executorService.shutdown();
    }

}

package thread.bean;

/**
 * @ClassName MyRunnable
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 10:07
 * @Version 1.0
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"实现Runnable-->"+i);
        }
    }
}

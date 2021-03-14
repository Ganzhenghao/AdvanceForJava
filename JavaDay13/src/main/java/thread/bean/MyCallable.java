package thread.bean;

import java.util.concurrent.Callable;

/**
 * @ClassName MyCallable
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/5 10:31
 * @Version 1.0
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {

        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+"给女孩表白"+i+"次");
        }

        return "表白成功";
    }
}

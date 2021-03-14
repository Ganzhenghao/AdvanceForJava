package homework;

import java.util.concurrent.Callable;

/**
 * @ClassName SumCallable
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 19:07
 * @Version 1.0
 */
public class SumCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            sum += i;
        }
        return sum;
    }
}

package homework;

import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

/**
 * @ClassName AverageThread
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 19:29
 * @Version 1.0
 */
public class AverageCallable implements Callable<BigDecimal> {



    @Override
    public BigDecimal call() throws Exception {
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += RandomUtils.nextInt(1, 101);
        }
        BigDecimal avg = BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(10), 2, RoundingMode.HALF_UP);
        System.out.println(Thread.currentThread().getName()+"-->AVG = " +avg);
        return avg;
    }
}

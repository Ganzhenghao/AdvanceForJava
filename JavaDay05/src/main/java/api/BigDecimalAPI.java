package api;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName BigDecimalAPI
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 10:35
 * @Version 1.0
 */
public class BigDecimalAPI {
    @Test
    public void bigDecimal() {
        double db = 0.1;
        System.out.println("db = " + db);
        System.out.println("new BigDecimal(0.1) = " + new BigDecimal(0.1));
        System.out.println("new BigDecimal(\"0.1\") = " + new BigDecimal("0.1"));
        System.out.println("BigDecimal.valueOf(0.1) = " + BigDecimal.valueOf(0.1));
    }

    @Test
    public void bigDecimalOperate() {
        BigDecimal b1 = BigDecimal.valueOf(0.1);
        BigDecimal b2 = BigDecimal.valueOf(0.3);

        System.out.println("b1.add(b2) = " + b1.add(b2));
        System.out.println("b1.subtract(b2) = " + b1.subtract(b2));
        System.out.println("b1.multiply(b2) = " + b1.multiply(b2));
        System.out.println("b1.divide(b2) = " + b1.divide(b2, 2,RoundingMode.HALF_UP));


    }
}

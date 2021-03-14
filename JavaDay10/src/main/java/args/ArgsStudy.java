package args;

import org.junit.Test;

/**
 * @ClassName ArgsStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/1 9:41
 * @Version 1.0
 */
public class ArgsStudy {

    public int getSum(int... elements) {
        int sum = 0;
        for (int element : elements) {
            sum += element;
        }
        return sum;
    }

    @Test
    public void argsTest() {
        System.out.println("getSum(1,3,5,7,9,11) = " + getSum(1, 3, 5, 7, 9, 11));
    }

}

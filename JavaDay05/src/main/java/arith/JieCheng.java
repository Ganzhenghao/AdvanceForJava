package arith;

/**
 * @ClassName JieCheng
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 15:38
 * @Version 1.0
 */
public class JieCheng {
    public static void main(String[] args) {
        int result = getJieCheng(10);
        System.out.println(result);
    }

    private static int getJieCheng(int i) {
        if (i == 1) {
            return 1;
        }
        return i * getJieCheng(i - 1);
    }
}

package arith;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 15:17
 * @Version 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 6, 2, 4, 77, 33, 43};
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j] > ints[j + 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
        }
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }
}

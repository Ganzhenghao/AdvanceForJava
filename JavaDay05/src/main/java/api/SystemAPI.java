package api;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName SystemAPI
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 9:11
 * @Version 1.0
 */
public class SystemAPI {

    //  数组复制  arraycopy(数据源数组,目标位置索引,目标数组,目标位置索引,复制的元素个数)
    @Test
    public void arraycopy() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[5];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        Arrays.stream(arr2).forEach(System.out::println);

    }

}

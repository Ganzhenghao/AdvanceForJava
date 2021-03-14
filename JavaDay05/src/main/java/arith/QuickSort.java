package arith;

import java.util.Arrays;

/**
 * @ClassName QiuckSort
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 16:16
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] ints = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(ints, 0, ints.length - 1);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }


    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {

        //递归出口
        if (rightIndex <= leftIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        int base = arr[left];
        //如果left的索引小于right索引 则继续循环
        while (left != right) {
            //从右向左找 找比基准数小的
            while (arr[right] >= base && left < right) {
                //当数组对应索引元素比基准数大时,索引向左移动一位,直到数组对应索引元素比基准数小时,结束循环
                right--;
            }
            //从左往右找 找比基准数大的
            while (arr[left] <= base && left < right) {
                //当数组对应索引元素比基准数小时,索引向右移动一位,直到数组对应索引元素比基准数大时,结束循环
                left++;
            }

            //得到左右两个索引后 交换元素
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        //基准数归位 当以上循环结束时,left = right
        int temp = arr[left];
        arr[left] = base;
        arr[leftIndex] = temp;

        // 递归进行左右双排序
        quickSort(arr, 0, left - 1);
        quickSort(arr, left + 1, rightIndex);

    }


}

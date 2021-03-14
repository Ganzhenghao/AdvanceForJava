package arith;

import java.util.Scanner;

/**
 * @ClassName BinarySearch
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 14:28
 * @Version 1.0
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] ints = new int[100];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number :");
        int number = sc.nextInt();
        int index = binarySearch(ints, number);
        System.out.println("index = " + index);
    }

    private static int binarySearch(int[] ints, int number) {
        int min = 0;
        int max = ints.length - 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            //int mid = (max - min) >> 1;
            if (ints[mid] > number){
                max = mid -1;
            }else if(ints[mid] < number){
                min = mid +1;
            }else{
                return mid;
            }
        }
        return -1;
    }



}

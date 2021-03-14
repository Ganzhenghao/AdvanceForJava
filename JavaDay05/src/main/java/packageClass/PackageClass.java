package packageClass;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName PackageClass
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/21 11:26
 * @Version 1.0
 */
public class PackageClass {

    @Test
    public void integer() {
        Integer integer1 = Integer.valueOf(50);
        Integer integer2 = Integer.valueOf("200");
        System.out.println("integer1 = " + integer1);
        System.out.println("integer2 = " + integer2);
    }

    @Test
    public void splitString() {
        String s = "98 556 45 56";
        String[] strings = s.split(" ");
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        Arrays.stream(ints).forEach(System.out::println);

        Arrays.sort(ints);
        System.out.println("Arrays.binarySearch(ints, 98) = " + Arrays.binarySearch(ints, 98));
    }


}

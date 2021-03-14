import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StreamToArrayTest
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/13 9:55
 * @Version 1.0
 */
public class StreamToArrayTest {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }


        Integer[] toArray = arrayList.stream().filter(integer -> integer % 2 == 0)
                .toArray(value -> new Integer[value]);

        System.out.println(Arrays.toString(toArray));


    }

}

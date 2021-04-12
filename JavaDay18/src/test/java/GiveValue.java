import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName GiveValue
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/26 20:36
 * @Version 1.0
 */
public class GiveValue {
    public static void main(String[] args) {

        int i = 5;
        int j = 10;
        System.out.println(i + ~j);

    }

    @Test
    public void testMethodName() {
        String s = "a,b,c,,";
        String[] split = s.split(",");
        System.out.println(split.length);
        Arrays.stream(split).forEach(System.out::println);
        System.out.println("null");
    }

    @Test
    public void one() {
        //String str = new Scanner(System.in).nextLine();
        String str = "Jkdi234klowe90a3\n" +
                "5151javascript:void(0);";
        String newStr = str.replaceAll("\\D", ",");
        String[] split = newStr.split(",");
        StringBuilder stringBuilder = new StringBuilder("*");
        for (String ch : split) {
            if (!(ch + "").equals("")) {
                stringBuilder.append(ch);
                stringBuilder.append("*");
            }

        }
        System.out.println(stringBuilder);
    }
}

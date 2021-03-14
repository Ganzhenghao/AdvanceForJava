import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName RegxTest
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/1 21:08
 * @Version 1.0
 */
public class RegxTest {
    public static void main(String[] args) {

        String str = "<h1>good day</h1><h1>good day</h1><h1>good day</h1><h1>good day</h1>";
        String regx = "<h1>(.*?)</h1>";



        Matcher matcher = Pattern.compile(regx).matcher(str);
        //System.out.println(matcher.matches());
        // System.out.println(matcher.find());

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

/*        System.out.println(matcher.group(0));

        System.out.println(matcher.group(1));*/

    }
}

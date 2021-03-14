package exam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName ThreeAnother
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/7 14:27
 * @Version 1.0
 */
public class ThreeAnother {

    public static void main(String[] args) {
        final Properties properties = new Properties();
        try {
            properties.load(new FileReader("JavaDay15/src/main/resources/count.properties"));
            final String count = properties.getProperty("count");
            if (count == null) {
                properties.setProperty("count", "1");
                properties.store(new FileWriter("JavaDay15/src/main/resources/count.properties"), null);
                System.out.println("第1次使用该程序");
            } else {
                if (Integer.parseInt(count) < 4) {
                    int time = Integer.parseInt(count)+1;
                    System.out.println("第" + time + "次使用该程序");
                    properties.setProperty("count",String.valueOf(time));
                    properties.store(new FileWriter("JavaDay15/src/main/resources/count.properties"), null);
                } else {
                    System.out.println("您的使用次数已经达到试用上限，请充值后继续使用");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName ClassLoaderStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 10:08
 * @Version 1.0
 */
public class ClassLoaderStudy {
    public static void main(String[] args) throws IOException {

        final InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("pro.properties");
        final Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println("properties = " + properties);


    }
}

package io;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName PropertiesStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/4 8:41
 * @Version 1.0
 */
public class PropertiesStudy {
    @Test
    public void twelve() {
        Properties properties = new Properties();

        properties.setProperty("A", "a");
        properties.setProperty("B", "b");
        properties.setProperty("C", "c");

        System.out.println("properties.getProperty(\"A\") = " + properties.getProperty("A"));

        properties.stringPropertyNames().forEach(s -> System.out.println(s+"="+properties.getProperty(s)));
    }

    @Test
    public void thirteen() throws IOException {
        Properties properties = new Properties();
        FileReader reader = new FileReader("src/main/resources/config.properties");
        properties.load(reader);
        System.out.println("properties = " + properties);
        reader.close();
    }

    @Test
    public void fourteen() {

        Properties properties = new Properties();
        properties.setProperty("name", "狗蛋");
        properties.setProperty("realName", "李狗蛋");
        properties.setProperty("username", "noname");
        properties.setProperty("password", "123456");
        try (FileWriter writer = new FileWriter("src/main/resources/config.properties")) {
            properties.store(writer, "这是一个UTF8的属性文件");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

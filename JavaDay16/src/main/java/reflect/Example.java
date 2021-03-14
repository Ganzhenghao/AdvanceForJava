package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @ClassName example
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 16:05
 * @Version 1.0
 */
public class Example {

    public static void main(String[] args) {

        final InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("pro.properties");

        final Properties properties = new Properties();
        try(in) {
            properties.load(in);

            String className = properties.getProperty("class");
            String methodName = properties.getProperty("method");


            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getConstructor().newInstance();

            clazz.getMethod(methodName).invoke(instance);


        } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }


    }


}

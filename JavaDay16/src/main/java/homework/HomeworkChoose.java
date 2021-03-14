package homework;

import homework.bean.Person;
import homework.bean.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName HomeworkChoose
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 16:42
 * @Version 1.0
 */
public class HomeworkChoose {
    @Test
    public void one() {
//        需求：定义一个Student类，用反射去创建一个Student对象，要求使用两种方式：
//        1. 通过Class对象的方法创建。
//        2. 通过Constructor对象的方法创建。

        Class<Student> clazz = Student.class;
        try {
            Student s1 = clazz.getConstructor().newInstance();
            //Student s2 = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    //        1.写一个方法，此方法可将obj对象中名为propertyName的属性的值设置为value.
    public void setProperty(Object obj, String propertyName, Object value) {

        try {
            Class<?> clazz = obj.getClass();
            Field field = clazz.getDeclaredField(propertyName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }


    //        2. 写一个方法，此方法可以获取obj对象中名为propertyName的属性的值
    public Object getProperty(Object obj, String propertyName) {

        try {
            Class<?> clazz = obj.getClass();

            Field field = clazz.getField(propertyName);
            field.setAccessible(true);

            field.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }

//    1. 定义一个Person类，包含私有属性name、age，getXxx和setXxx方法和有参满参构造方法。
//    2. 使用反射的方式创建一个实例、调用构造函数初始化name、age。使用反射方式调用setName方法对姓名进行设置，不使用setAge方法直接使用反射方式对age赋值。

    @Test
    public void three() {

        try {
            Class<Person> clazz = Person.class;
            Person person = clazz.getConstructor(String.class, int.class).newInstance("张三", 15);
            Method method = clazz.getMethod("setName", String.class);
            method.invoke(person, "大毛");

            Field age = clazz.getDeclaredField("age");
            age.setAccessible(true);
            age.set(person, 18);
            System.out.println(person);


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }


//    写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，
//    用反射的方式运行run方法。

    @Test
    public void four() {
        try (InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            String className = properties.getProperty("class");

            Class<?> clazz = Class.forName(className);

            Method run = clazz.getMethod("run");
            run.invoke(clazz.getConstructor().newInstance());


        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
        }
    }

}

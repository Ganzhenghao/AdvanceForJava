package homework;

import homework.bean.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName Homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 16:19
 * @Version 1.0
 */
public class Homework {
    public static void main(String[] args) {

//        1). 使用反射获取Student的Class对象。
//        2). 获取 “公有、全参构造方法”；
//        3). 调用 “公有、全参构造方法”传入：“柳岩”,17两个参数。
//        4). 反射获取show()方法
//        5). 调用show()方法

        Class<Student> clazz = Student.class;


        try {
            Constructor<Student> constructor = clazz.getConstructor(String.class, int.class);

            Student student = constructor.newInstance("柳岩", 17);

            Method show = clazz.getMethod("show");
            show.invoke(student);

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}

package reflect;

import bean.Student;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName ReflectStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 8:58
 * @Version 1.0
 */
public class ReflectStudy {
    private Class<?> clazz;

    @Before
    public void before() {
        try {
            clazz = Class.forName("bean.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void one() throws ClassNotFoundException {
        final Class<?> clazz1 = Class.forName("bean.Student");
        final Class<Student> clazz2 = Student.class;
        final Class<? extends Student> clazz3 = new Student().getClass();

        System.out.println("clazz1 = " + clazz1);
        System.out.println("clazz2 = " + clazz2);
        System.out.println("clazz3 = " + clazz3);
    }

    @Test
    public void two() throws NoSuchMethodException {
        Arrays.stream(clazz.getConstructors()).forEach(System.out::println);
        System.out.println("==============================");
        Arrays.stream(clazz.getDeclaredConstructors()).forEach(System.out::println);
        System.out.println("==============================");
        System.out.println(clazz.getConstructor());
        System.out.println("clazz.getConstructor(String.class,int.class) = " + clazz.getConstructor(String.class, int.class));
        System.out.println("==============================");
        System.out.println(clazz.getDeclaredConstructor(String.class));
    }

    @Test
    public void three() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Student student = (Student) clazz.getConstructor().newInstance();
        System.out.println("student.getName() = " + student.getName());


        final Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Student student1 = (Student) constructor.newInstance("张三");
        System.out.println("student1.getName() = " + student1.getName());

    }

    @Test
    public void four() throws NoSuchFieldException {

        Arrays.stream(clazz.getFields()).forEach(System.out::println);
        System.out.println("=====================================");
        Arrays.stream(clazz.getDeclaredFields()).forEach(System.out::println);
        System.out.println("=====================================");
        System.out.println("clazz.getFields(\"name\") = " + clazz.getField("name"));
        System.out.println("=====================================");
        System.out.println("clazz.getDeclaredFields(\"money\") = " + clazz.getDeclaredField("money"));
    }


    @Test
    public void five() {
        try {
//            Student student = (Student) clazz.getConstructor().newInstance();
            Object student = clazz.getConstructor().newInstance();
            final Field money = clazz.getDeclaredField("money");
            money.setAccessible(true);
            money.set(student, 666);
            System.out.println("student = " + student);
            System.out.println("money.get(student) = " + money.get(student));

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void six() {
        try {
            Student student = (Student) clazz.getConstructor().newInstance();
            Arrays.stream(clazz.getMethods()).forEach(System.out::println);
            System.out.println("===========================================");

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void seven() {
        final Class<Student> clazz = Student.class;
        try {
            final Student student = clazz.getConstructor().newInstance();
            final Method fatherSay = clazz.getMethod("fatherSay");

            final Object invoke = fatherSay.invoke(student);

            final Method function4 = clazz.getDeclaredMethod("function4", String.class);

            final Object result = function4.invoke(student, "good");
            System.out.println("result = " + result);


        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void eight() {

        final ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(102);
        list.add(140);

        final Class<? extends ArrayList> clazz = list.getClass();

        try {
            final Method add = clazz.getMethod("add", Object.class);
            add.invoke(list, "a");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(list);

    }

    @Test
    public void nine() {
        System.out.println("clazz.getName() = " + clazz.getName());
    }



}

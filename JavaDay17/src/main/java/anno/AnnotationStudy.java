package anno;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName AnnotationStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/12 9:42
 * @Version 1.0
 */
public class AnnotationStudy {
    public static void main(String[] args){

        try {
            Class<?> clazz = Class.forName("anno.UseTest");
            Object o = clazz.getConstructor().newInstance();
            for (Method method : clazz.getMethods()) {
                if (method.isAnnotationPresent(MyTest.class)){
                    method.invoke(o);
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}

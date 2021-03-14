package generic;

import bean.Box;
import bean.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName GenericStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 21:19
 * @Version 1.0
 */
public class GenericStudy {
    @Test
    public void genericClass() {
        Box<String> box = new Box<>();
        box.setElement("String Box");
        box.setList(new ArrayList<>());
        System.out.println("box.getElement() = " + box.getElement());
        System.out.println("box.getList() = " + box.getList());
    }

    @Test
    public void genericMethod() {
        Box<String> box = new Box<>();
        System.out.println(box.createAndReturn(new Student("张三", 18)));
        System.out.println("addElement: " + addElement(new ArrayList<>(), 1, 2, 3, 4, 5, 6));
    }

    @Test
    public void genericInterface() {

    }

    @SafeVarargs
    private <T> List<T> addElement(List<T> list, T... args) {
        list.addAll(Arrays.asList(args));
        return list;
    }

    @Test
    public void genericLineTest() {

        System.out.println(genericLine(addElement(new ArrayList<>(), 1, 2, 3)));
    }

    public List<? extends Number> genericLine(List<? extends Number> list) {
        return list;
    }

    public <T extends Number> T methodName(T list) {
        return list;
    }

}

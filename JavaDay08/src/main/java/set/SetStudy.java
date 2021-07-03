package set;

import bean.Student;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName SetStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 21:18
 * @Version 1.0
 */
public class SetStudy {

    private final Set<Student> studentHashSet = new HashSet<>();
    private final Set<Student> studentTreeSet = new TreeSet<>();

    @Test
    public void hashSet() {
        studentHashSet.add(new Student("zhangsan", 18));
        studentHashSet.add(new Student("zhangsan", 18));
        System.out.println(studentHashSet);
    }

    @Test
    public void treeSet() {
        studentTreeSet.add(new Student("zhangsan", 18));
        studentTreeSet.add(new Student("zhangsan", 19));
        System.out.println(studentTreeSet);
    }

    @Test
    public void setSpecial() {
        Set<Object> set = new TreeSet<>();
        set.add("a");
        set.add("a");
        set.add("c");
        set.add("d");
        set.add("b");
        System.out.println(set);
    }

    @Test
    public void compareToStudent() {
        studentTreeSet.add(new Student());
        studentTreeSet.add(new Student());
        studentTreeSet.add(new Student("里四", 19));
        studentTreeSet.add(new Student("王五", 17));
        studentTreeSet.add(new Student("里四", 20));
        studentTreeSet.add(new Student("赵六", 20));
        System.out.println(studentTreeSet);
    }

    @Test
    public void comparator() {
        TreeSet<Student> students = new TreeSet<>(Comparator.comparingInt(Student::getAge).thenComparing(Student::getName));
        studentTreeSet.add(new Student("里四", 19));
        studentTreeSet.add(new Student("王五", 17));
        studentTreeSet.add(new Student("里四", 20));
        studentTreeSet.add(new Student("赵六", 20));
        System.out.println(students);
    }

    @Test
    public void testComparator() {

        Student student = new Student("张三", 19);
        Student student1 = new Student("李四", 17);
        Student student2 = new Student("王五", 16);
        Student student3 = new Student("赵六", 20);

        ArrayList<Student> list = new ArrayList<>();
        list.add(student );
        list.add(student1);
        list.add(student2);
        list.add(student3);

        Collections.sort(list, (o1, o2) -> {
            System.out.println("o1 = " + o1);
            System.out.println("o2 = " + o2);
            System.out.println(o1.getAge() - o2.getAge());
            return o1.getAge() - o2.getAge();
        });

        System.out.println(list);

    }




}

package list;

import bean.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName ListStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 8:56
 * @Version 1.0
 */
public class ListStudy {

    List<String> stringList = new ArrayList<>();
    List<Integer> integerListList = new ArrayList<>();


    @Before
    public void before() {
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");
        integerListList.add(1);
        integerListList.add(2);
        integerListList.add(3);
        integerListList.add(4);
        integerListList.add(5);
    }

    @Test
    public void listOne() {
        // 调用remove(object o) 不会自动拆箱
        integerListList.remove(Integer.valueOf(1));
        System.out.println(integerListList);
        integerListList.remove(1);
        System.out.println(integerListList);

    }

    @Test
    public void listTwo() {
        // 依旧调用remove(object o) 不会自动拆箱
        boolean result = stringList.remove(Integer.valueOf(1));
        System.out.println(result);

    }


    @Test
    public void iterators() {

        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void iteratorTest() {
        for (int i = 0; i <size(integerListList) ; i++) {
            if (integerListList.get(i) == 2){
                integerListList.remove(i);
            }
        }
    }

    private int size(List<?> list){
        System.out.println("list.size() = " + list.size());
        return list.size();
    }

    @Test
    public void iteratorRemove() {
        Iterator<Integer> iterator = integerListList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == 2) {
                iterator.remove();
            }
        }
    }

    @Test
    public void forPlus() {
        for (Integer integer : integerListList) {
            System.out.println(integer);
        }
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    @Test
    public void studentIterator() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            students.add(new Student("学生"+(i+1)+"号",(i+18)));
        }
        //students.listIterator();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void listMethodPractice() {
        System.out.println(stringList.set(0, "666"));
        System.out.println(stringList);

        System.out.println(stringList.remove(0));
        System.out.println(stringList);
        System.out.println(stringList.get(2));

    }

    @Test
    public void linkedList() {
        LinkedList<Object> list = new LinkedList<>();

        list.add(1);
        list.add("two");
        list.add(new Student("张三", 18));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (Object o : list) {
            System.out.println(o);
        }

        Iterator<Object> iterator = list.iterator();
        while (iterator
                .hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void linkedListTwo() {
        LinkedList<Object> list = new LinkedList<>();

        list.add(1);
        list.add("two");
        list.add(new Student("张三", 18));

        System.out.println("list.getFirst() = " + list.getFirst());
        System.out.println("list.getLast() = " + list.getLast());

        list.addFirst("good");
        list.addLast("JOB");

        System.out.println("list = " + list);
        System.out.println("list.removeFirst() = " + list.removeFirst());
        System.out.println("list.removeLast() = " + list.removeLast());
        System.out.println("list = " + list);

    }

    @Test
    public void testMethodName() {
        Object[] objects = new Object[5];
        objects[0]=5;
        objects[1]="5";
        System.out.println(Arrays.toString(objects));
    }

    @Test
    public void array() {
        int[] ints = {1, 2, 3, 4, 5};
    }


}

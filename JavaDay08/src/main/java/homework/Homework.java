package homework;

import homework.bean.IDataOperationImpl;
import homework.bean.Student;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName Homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/24 21:20
 * @Version 1.0
 */
public class Homework {
    @Test
    public void one() {
        IDataOperationImpl iDataOperation = new IDataOperationImpl();
        iDataOperation.add(new Student("1","zhangsan","18","sichuan"));
        iDataOperation.add(new Student("2","zhangsan","18","sichuan"));
        iDataOperation.add(new Student("3","zhangsan","18","sichuan"));
        iDataOperation.add(new Student("1","zhangsan","18","sichuan"));
        iDataOperation.add(new Student("1","zhangsan","18","sichuan"));
        System.out.println(iDataOperation.getAll());
    }


    /*
    需求：定义一个方法boolean  listTest(ArrayList<String> al, String s),
    要求使用contains()方法判断al集合里面是否包含s。
     */

    private boolean listTest(ArrayList<String> al, String s){
        return al.contains(s);
    }


    /*
    需求：定义一个方法boolean  listTest(ArrayList<String> al),
    要求使用isEmpty()判断al里面是否有元素。
     */
    private boolean  listTest(ArrayList<String> al){
        return al.isEmpty();
    }

    /*
    需求：
    1. 编写一个泛型方法，实现任意引用类型数组能够将指定位置元素交换。
    2. 提示：泛型方法可以定义为：public static <E> void method( E[] e,int a,int b){}
     */
    public<E> void changeElement( E[] e,int a,int b) {
        E temp = e[a];
        e[a] = e[b];
        e[b] = temp;
    }

    /*
    1. 编写一个泛型方法，接收一个任意引用类型的数组，并反转数组中的所有元素。
    2. 提示：泛型方法可以定义为**public static** <E> **void** method( E[] e){}
     */

    public <E> void revers(E[] e){
        E temp;
        for (int i = 0; i < e.length; i++) {
            temp = e[0];
            e[0] = e[e.length-i-1];
            e[e.length-i-1] = temp;
        }
    }

    /*
    需求：提供一个函数，可以向保存任意类型数据的集合容器中添加一个相应类型的数据；
    例如，向保存字符串的集合中添加字符串，向保存int型数组的集合中添加int型数组对象；
     */
    public <E> Collection<E> addElement(Collection<E> collection,E element){
        collection.add(element);
        return collection;
    }


    /*
    	请编写main()方法，按以下要求顺序
    	定义一个TreeSet集合，并存储以下数据：
    刘备，关羽，张飞，刘备，张飞
    	打印集合大小
    	使用迭代器遍历集合，并打印每个元素
    	使用增强for遍历集合，并打印每个元素
     */

    @Test
    public void mustOne() {
        Set<String> set = new TreeSet<>();
        set.add("刘备");
        set.add("关羽");
        set.add("张飞");
        set.add("刘备");
        set.add("张飞");
        System.out.println("set.size() = " + set.size());
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (String s : set) {
            System.out.println(s);
        }
    }

    /*
    请按以下要求顺序编码：
    	定义一个可以存储“整数”的TreeSet对象
    	存储以下整数
    30,20,50,10,30,20
    	打印集合大小。为什么跟存入的数量不一致？
    	遍历集合，打印大于25的元素
     */
    @Test
    public void mustTwo() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(30);
        set.add(20);
        set.add(50);
        set.add(30);
        set.add(20);
        System.out.println("set.size() = " + set.size());
        set.forEach(System.out::println);
    }

    @Test
    public void mustThree() {
        TreeSet<homework.bean.must.Student> set = new TreeSet<>();
        set.add(new homework.bean.must.Student("张三",18, 88));
        set.add(new homework.bean.must.Student("李四",15, 68));
        set.add(new homework.bean.must.Student("王五",18, 92));
        set.add(new homework.bean.must.Student("赵六",25, 88));
        System.out.println(set);
    }


}

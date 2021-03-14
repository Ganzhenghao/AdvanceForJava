package stream;

import lombok.*;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName StreamStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/1 8:44
 * @Version 1.0
 */
public class StreamStudy {

    ArrayList<String> list = new ArrayList<>(List.of("张角", "张三丰", "张翠山", "林青霞"));

    @Test
    public void streamOne() {
        ArrayList<String> list1 = new ArrayList<>(List.of("张角", "张三丰", "张翠山", "林青霞"));
        ArrayList<String> list2 = new ArrayList<>();
        for (String s : list1) {
            if (s.startsWith("张")) {
                list2.add(s);
            }
        }
        ArrayList<String> list3 = new ArrayList<>();
        for (String s : list2) {
            if (s.length() == 3) {
                list3.add(s);
            }
        }
        System.out.println(list3);

        List<String> list = list1.stream().filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    @Test
    public void streamTwo() {
        ArrayList<String> list = new ArrayList<>();
        list.stream();
        HashSet<String> set = new HashSet<>();
        set.stream();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.keySet().stream();
        hashMap.entrySet().stream();
    }

    @Test
    public void streamThree() {
        ArrayList<String> list = new ArrayList<>(List.of("张角", "张三丰", "张翠山", "林青霞"));

        list.stream()
                .filter(s -> s.startsWith("张"))
                .forEach(System.out::println);
    }

    @Test
    public void streamFour() {
        list.stream().limit(2).forEach(System.out::println);
        System.out.println("-------------------------------");
        list.stream().skip(2).forEach(System.out::println);
        System.out.println("-------------------------------");
        Stream.concat(list.stream(), list.stream()).forEach(System.out::println);
        System.out.println("-------------------------------");
        Stream.concat(list.stream(), list.stream())
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void streamFive() {

        list.stream().forEach(System.out::println);
        System.out.println("-------------------------------");
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        System.out.println("-------------------------------");
        list.stream().forEach(s -> System.out.println(s));
        System.out.println("-------------------------------");
        System.out.println("list.stream().count() = " + list.stream().count());
    }


    @Test
    public void streamSix() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
        List<Integer> collect = list.stream().filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void streamSeven() {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三,14");
        list.add("李四,18");
        list.add("赵武,20");
        Stream<String> stream = list.stream();

        Map<String, String> map = stream
                .filter(s -> Integer.parseInt(s.split(",")[1]) > 16)
                .collect(Collectors.toMap(s -> s.split(",")[0],
                        s -> s.split(",")[1]));

        System.out.println(map);
    }

    @Test
    public void streamEight() {

        ArrayList<String> manList = new ArrayList<>(
                List.of("张三", "张杰", "张三丰", "张二码")
        );
        ArrayList<String> womanList = new ArrayList<>(
                List.of("杨三", "杨杰", "杨三丰", "杨二码")
        );

        Stream<String> stream1 = manList.stream().filter(s -> s.startsWith("张")).limit(2);
        Stream<String> stream2 = womanList.stream().filter(s -> s.startsWith("杨")).skip(1);

        Stream.concat(stream1, stream2).forEach(s -> System.out.println(new Actor(s)));

    }

    @Test
    public void distinctTest() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student());
        list.add(new Student());
        list.add(new Student());
        list.add(new Student("李四", 15));
        list.stream().distinct().forEach(System.out::println);

    }


    @Test
    public void intStream() {
        IntStream.Builder builder = IntStream.builder();
        IntStream.Builder add = builder.add(1).add(2).add(3);
        add.build().forEach(System.out::println);
    }


}

@FunctionalInterface
interface TestOne {
    void method(String s);
}

class TestTwo {
    public void method(TestOne t) {
        t.method("good");
    }

    public static void method1(String s) {

    }

    public void method2(String s) {

    }

    public void test() {
        new TestTwo().method(TestTwo::method1);
        new TestTwo().method(new TestTwo()::method2);
        //new TestTwo().method(new TestTwo()::method2);
    }

}

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
class Student {
    private String name;
    private int age;

    public Student() {
        this.name = "张三";
        this.age = 18;
    }

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (getAge() != student.getAge()) return false;
        return getName() != null ? getName().equals(student.getName()) : student.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getAge();
        return result;
    }*/
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Actor {
    private String name;
}
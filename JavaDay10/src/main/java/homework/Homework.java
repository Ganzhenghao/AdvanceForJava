package homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName Homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/1 8:43
 * @Version 1.0
 */
public class Homework {

    private List<String> list = new ArrayList<>(List.of("张三丰", "王思聪", "张飞", "刘晓敏", "张靓颖"));
    private List<String> list2 = new ArrayList<>(
            List.of("王佳乐", "张三丰", "王思聪", "张飞", "刘晓敏", "张靓颖", "王敏")
    );

    /*
    	定义main()方法，按以下顺序编写程序：
	定义集合List<String>，添加以下数据：
			“张三丰”
			“王思聪”
			“张飞”
			“刘晓敏”
			“张靓颖”
	使用Stream流的forEach()方法打印集合的所有元素
     */
    @Test
    public void mustOne() {
        list.stream().forEach(System.out::println);
    }

    /*
    	定义集合List<String>，添加以下数据：
			“张三丰”
			“王思聪”
			“张飞”
			“刘晓敏”
			“张靓颖”
	使用Stream流的filter()方法筛选集合中所有的“张”姓学员；
	筛选后，使用forEach()方法打印筛选结果。

     */
    @Test
    public void mustTwo() {
        list.stream().filter(s -> s.startsWith("张"))
                .forEach(System.out::println);
    }

    /*
    	定义集合List<String>，添加以下数据：
			“张三丰”
			“王思聪”
			“张飞”
			“刘晓敏”
			“张靓颖”
	使用Stream流的filter()方法筛选集合中所有的“张”姓学员；
	筛选后，使用count()方法获取筛选的数量。

     */
    @Test
    public void mustThree() {
        System.out.println(list.stream().filter(s -> s.startsWith("张"))
                .count());
    }

    /*
    	定义集合List<String>，添加以下数据：
	“王佳乐”
			“张三丰”
			“王思聪”
			“张飞”
			“刘晓敏”
			“张靓颖”
			“王敏”
	使用Stream流的filter()方法筛选集合中所有的“张”姓学员；
	筛选后，获取前两个，并打印。
	重新获取Stream流，用filter()方法筛选出所有的“王”姓学员；
	筛选后，跳过前1个，打印剩余的人员。
     */
    @Test
    public void mustFour() {

        list2.stream().filter(s -> s.startsWith("张"))
                .limit(2)
                .forEach(System.out::println);

        list2.stream().filter(s -> s.startsWith("王"))
                .skip(1)
                .forEach(System.out::println);
    }

    /*
    	定义集合List<String>，添加以下数据：
	“王佳乐”
			“张三丰”
			“王思聪”
			“张飞”
			“刘晓敏”
			“张靓颖”
			“王敏”
	先筛选出所有的“张”姓学员；
	再筛选出所有的“王”姓学员；
	将两个流合并为一个流
	打印合并后的每个元素。
     */
    @Test
    public void mustFive() {
        Stream<String> stream1 = list2.stream().filter(s -> s.startsWith("张"));
        Stream<String> stream2 = list2.stream().filter(s -> s.startsWith("王"));
        Stream.concat(stream1, stream2).forEach(System.out::println);
    }

    /*
    	1.定义一个Person类，包含一个属性：姓名(String)
	  	定义无参、全参构造方法
		定义get/set方法
	2.定义main()方法，按依稀顺序编写程序：
	定义集合List<String>，添加以下数据：
		“王佳乐”
		“张三丰”
		“王思聪”
		“张飞”
	使用Stream流的map()方法，将每个元素封装为一个Person对象。
	将新流中的元素提取为List集合。
	遍历、打印集合中所有的Person对象信息。
     */
    @Test
    public void mustSix() {
        ArrayList<String> list = new ArrayList<>(
                List.of("王佳乐", "张三丰", "王思聪", "张飞")
        );
        list.stream().map(Person::new).forEach(System.out::println);
    }

    /*
    有如下7个元素黄药师，冯蘅，郭靖，黄蓉，郭芙，郭襄，郭破虏，使用Stream将以郭字开头的元素存入新数组。
    1.使用Stream的of()方法将7个元素封装成Stream对象
    2.使用Stream的filter方法过滤出符合要求的数据
    3.结合Arrays的toString()方法2中的结果输出在控制台
     */
    @Test
    public void mayOne() {
        String[] strings = Stream.of("黄药师", "冯蘅", "郭靖", "黄蓉", "郭芙", "郭襄", "郭破虏")
                .filter(s -> s.startsWith("郭"))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }

    /*
    已知ArrayList集合中有如下元素{陈玄风、梅超风、陆乘风、曲灵风、武眠风、冯默风、罗玉风}，请使用Stream：
    1. 取出前2个元素并在控制台打印输出。
    2. 取出后2个元素并在控制台打印输出。
     */
    @Test
    public void mayTwo() {
        ArrayList<String> list = new ArrayList<>(
                List.of("陈玄风", "梅超风", "陆乘风", "曲灵风", "武眠风", "冯默风", "罗玉风"));
        list.stream().limit(2).forEach(System.out::println);
        System.out.println("=================================");
        list.stream().skip(5).forEach(System.out::println);
    }

    /*
    有如下整数1，-2，-3，4，-5，使用Stream取元素绝对值并打印
     */
    @Test
    public void mayThree() {
        Stream.of(1, -2, -3, 4, -5)
                .map(Math::abs)
                .forEach(System.out::println);
    }

    /*
    已知数组arr1中有如下元素{郭靖，杨康}，
    arr2中有如下元素{黄蓉，穆念慈}，使用Stream将二者合并到List集合。
     */

    @Test
    public void mayFour() {
        String[] s1 = {"郭靖","杨康"};
        String[] s2 = {"黄蓉","穆念慈"};

        List<String> collect = Stream.concat(Arrays.stream(s1), Arrays.stream(s2))
                .collect(Collectors.toList());
    }

    /*
    现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用Stream方式进行以
    下若干操作步骤：
    1. 第一个队伍只要名字为3个字的成员姓名；
    2. 第一个队伍筛选之后只要前6个人；
    3. 第二个队伍只要姓张的成员姓名；
    4. 第二个队伍筛选之后不要前1个人；
    5. 将两个队伍合并为一个队伍；
    6. 根据姓名创建Student对象；
    7. 打印整个队伍的Student对象信息。
     */
    @Test
    public void mayFive() {
        List<String> one = new ArrayList<>();
        one.add("陈玄风");
        one.add("梅超风");
        one.add("陆乘风");
        one.add("曲灵风");
        one.add("武眠风");
        one.add("冯默风");
        one.add("罗玉风");
        Stream<String> stream1 = one.stream().filter(s -> s.length() == 3)
                .limit(6);
        List<String> two = new ArrayList<>();
        two.add("宋远桥");
        two.add("俞莲舟");
        two.add("俞岱岩");
        two.add("张松溪");
        two.add("张翠山");
        two.add("殷梨亭");
        two.add("莫声谷");
        Stream<String> stream2 = two.stream().filter(s -> s.startsWith("张"))
                .skip(1);

        Stream.concat(stream1, stream2)
                .map(Student::new)
                .forEach(System.out::println);
    }

    /*
    名次\名称  全球  华人
    1《教父》       《霸王别姬》
    2《肖申克的救赎》《大闹天宫》
    3《辛德勒的名单》《鬼子来了》
    4《公民凯恩》   《大话西游》
    5《卡萨布兰卡》 《活着》
    6《教父续集》          《饮食男女》
    7《七武士》            《无间道》
    8《星球大战》          《天书奇谭》
    9《美国美人》          《哪吒脑海》
    10《飞跃疯人院》       《春光乍泄》
     */
    @Test
    public void maySix() {


        ArrayList<String> world = new ArrayList<>(List.of(
                "《教父》",
                "《肖申克的救赎》",
                "《辛德勒的名单》",
                "《公民凯恩》",
                "《卡萨布兰卡》",
                "《教父续集》",
                "《七武士》",
                "《星球大战》",
                "《美国美人》",
                "《飞跃疯人院》"
        ));
        ArrayList<String> chinese = new ArrayList<>(List.of(
                "《霸王别姬》",
                "《大闹天宫》",
                "《鬼子来了》",
                "《大话西游》",
                "《活着》",
                "《饮食男女》",
                "《无间道》",
                "《天书奇谭》",
                "《哪吒脑海》",
                "《春光乍泄》"
        ));

        /*
        要求：1.现将两个榜单中的影片名，分别按排名顺序依次存入两个ArrayList集合
        2. 通过流的方式
        1）打印全球影片排行榜中的前三甲影片名
        2）打印华人影片排行榜中倒数5名的影片名
        3）将两个排行榜中的前5名挑出来共同存入新的集合
        4）定义电影Film类，以影片名为name创建Film对象并保存至集合
         */

        world.stream().limit(3).forEach(System.out::println);
        chinese.stream().skip(5).forEach(System.out::println);
        List<String> collect = Stream.concat(world.stream().limit(5), chinese.stream().limit(5))
                .collect(Collectors.toList());
        System.out.println(collect);
        @Data
        @AllArgsConstructor
        class Film{
            private String name;
        }
        List<Film> filmList = collect.stream().map(Film::new).collect(Collectors.toList());
        System.out.println(filmList);
    }

}

@Data
@AllArgsConstructor
class Film{
    private String name;
}


@Data
@NoArgsConstructor
@AllArgsConstructor
class Person {
    private String name;
}

class Student {
    private String name;
    public Student() { }

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Student {name='" + name + "'}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

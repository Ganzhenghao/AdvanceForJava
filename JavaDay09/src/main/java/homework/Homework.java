package homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName Homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/27 8:41
 * @Version 1.0
 */
public class Homework {
    /*
    	请按以下要求顺序编码：
	定义一个：键Integer，值String类型的HashMap集合
	存储以下数据：
1，”张三”
2，“李四”
1，“王五”
	打印集合大小；
	使用“键找值”的方式遍历集合，打印键和值；
	使用“键值对”的方式遍历集合，打印键和值；
	获取键为1的值，并打印
	获取键为10的值，并打印
	判断集合中是否有键：10
	删除键为1的键值对，删除完毕打印集合
     */
    @Test
    public void mustOne() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(1, "王五");
        System.out.println("map.size() = " + map.size());
        for (Integer key : map.keySet()) {
            System.out.println("key:" + key + " - value:" + map.get(key));
        }
        System.out.println("---------------------------------------------");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + " - value:" + entry.getValue());
        }
        System.out.println("map.get(1) = " + map.get(1));
        System.out.println("map.get(10) = " + map.get(10));
        System.out.println("map.containsKey(10) = " + map.containsKey(10));
        map.remove(1);
        System.out.println(map);
    }

    /*
    有以下字符串：
		String str = “fje你kw我FDQFj你feAF他Eajf他eo2FA我FEjfew”;
	请编程统计每个字符出现的次数
     */
    @Test
    public void mustTwo() {
        String str = "fje你kw我FDQFj你feAF他Eajf他eo2FA我FEjfew";
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        map.forEach((character, integer) -> System.out.println(character + " 出现了 " + integer + "次"));
    }

    /*
    ArrayList有以下元素: "a","f","b","c","a","d"，请用任意方式完成集合元素去重。去除集合中重复的元素。
     */

    @Test
    public void mustThree() {
        List<String> list = new ArrayList<>(
                Arrays.asList("a", "f", "b", "c", "a", "d")
        );
        Set<String> set = new HashSet<>(list);
        System.out.println(set);
        list.clear();
        list.addAll(set);
        System.out.println(list);
    }
    /*
    双色球规则，双色球每注投注号码由6个1—33的号码和1个1—16的号码组成。
    其中6个1-33的数字要求不能重复。请随机生成一注双色球号码。
     */

    @Test
    public void mustFour() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() != 6) {
            set.add(random.nextInt(33) + 1);
        }
        System.out.println(set + "  last:" + (random.nextInt(16) + 1));

    }

    /*
    Map集合中包含5对元素: 
    "邓超"->"孙俪", "李晨"->"范冰冰", "刘德华"->"柳岩", “黄晓明”->” Baby”,
    “谢霆锋”->”张柏芝”。使用keySet方式迭代出Map集合中的元素。
     */
    @Test
    public void mayOne() {
        Map<String, String> map = new HashMap<>();
        String str = "邓超,孙俪,李晨,范冰冰,刘德华,柳岩,黄晓明,Baby,谢霆锋,张柏芝";
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i = i + 2) {
            map.put(split[i], split[i + 1]);
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("key:" + key + " - value:" + map.get(key));
        }
    }

    /*
    需求：研发部门有5个人，信息如下：
    （姓名-工资）【柳岩=2100, 张亮=1700, 诸葛亮=1800, 灭绝师太=2600, 东方不败 =3800】,
    将以上员工的相关信息存放在适合的集合中,给柳岩涨工资300,迭代出每个元素的内容输出到控制台。
    1. 定义HashMap,姓名作为key,工资作为value
    2. 使用put方法添加需要的元素
    3. 获取到柳岩的工资
    4. 修改柳岩的工资为当前工资加上300
    5. 使用增强for+keySet迭代出每个员工的工资
     */
    @Test
    public void mayTwo() {
        Map<String, Integer> map = new HashMap<>();
        String str = "柳岩=2100, 张亮=1700, 诸葛亮=1800, 灭绝师太=2600, 东方不败 =3800";
        str = str.replace(" ", "");
        for (String element : str.split(",")) {
            String[] split = element.split("=");
            map.put(split[0], Integer.valueOf(split[1]));
        }
        Integer salary = map.get("柳岩");
        map.put("柳岩", salary + 300);
        for (String key : map.keySet()) {
            System.out.println(key + " - " + map.get(key));
        }
    }

    /*
    需求：使用集合保存并按以下格式输出下列数据：
    河北省:
        秦皇岛市:[海港区, 山海关区, 北戴河区, 昌黎县]
        唐山市:[路北区, 路南区, 古冶区, 开平区]
        石家庄市:[石家庄市, 长安区, 桥东区, 桥西区, 新华区；]
    河南省:
        郑州市:[中原区, 金水区, 二七区, 管城回族区]
        洛阳市:[西工区, 老城区, 涧西区, 洛龙区]
        开封市:[鼓楼区, 龙亭区, 顺河回族区, 禹王台区]
     */
    @Test
    public void mayThree() {
        Map<String, Map<String, List<String>>> map = new HashMap<>();
        Map<String, List<String>> hbMap = new HashMap<>();
        hbMap.put("秦皇岛市", new ArrayList<>(Arrays.asList("海港区", "山海关区", "北戴河区", "昌黎县")));
        hbMap.put("唐山市", new ArrayList<>(Arrays.asList("路北区", "路南区", "古冶区", "开平区")));
        hbMap.put("石家庄市", new ArrayList<>(Arrays.asList("石家庄市", "长安区", "桥东区", "桥西区", "新华区")));
        map.put("河北省", hbMap);

        Map<String, List<String>> hnMap = new HashMap<>();
        hnMap.put("郑州市", new ArrayList<>(Arrays.asList("中原区", "金水区", "二七区", "管城回族区")));
        hnMap.put("洛阳市", new ArrayList<>(Arrays.asList("西工区", "老城区", "涧西区", "洛龙区")));
        hnMap.put("开封市", new ArrayList<>(Arrays.asList("鼓楼区", "龙亭区", "顺河回族区", "禹王台区")));
        map.put("河南省", hnMap);

        for (String e : map.keySet()) {
            System.out.println(e + ":");
            Map<String, List<String>> subMap = map.get(e);
            for (String s : subMap.keySet()) {
                System.out.println("\t" + s + ":" + subMap.get(s));
            }
        }
    }

    /*
    需求：一个年级有若干个班级，每个班级有若干个学生；要求：时
    1. 学生具有学号、姓名和成绩，学号和学生信息是一一对应的；
    2. 使用集合保存这个年级的所有学生的信息，然后遍历输出；
     */
    @Test
    public void mayFour() {
        @Data
        @AllArgsConstructor
        class Student {
            private String id;
            private String name;
            private int grade;
        }
        Map<String, Map<String, List<Student>>> map = new HashMap<>();

        // TODO 存数据

        for (Map.Entry<String, Map<String, List<Student>>> entry : map.entrySet()) {
            for (Map.Entry<String, List<Student>> stringListEntry : entry.getValue().entrySet()) {
                System.out.println(stringListEntry.getValue());
            }
        }
    }

    /*
    根据需求补足代码：
    对给定的数字列表进行分组，要求返回的Map中，Key为数字，Value为该数字出现的列表。
    例如，输入的数字列表为：[1,2,3,3,4,2]，
    那么返回值应为：{1=[1],2=[2,2],3=[3,3],4=[4]}
     */

    public static Map<Integer, List<Integer>> classify(Collection<Integer> numbers) {
        //创建一个Map集合，用于保存需要返回的数据
        Map<Integer, List<Integer>> map = new HashMap<>();
        //定义一个List类型的变量
        List<Integer> list = new ArrayList<>(numbers);
        for (Integer element : list) {
            /*           List<Integer> integers = map.get(element);
            if (integers == null || integers.isEmpty()) {
                integers = new ArrayList<>();
                integers.add(element);
                map.put(element, integers);
            }else {
                integers.add(element);
            }*/
            if (!map.containsKey(element)) {
                List<Integer> integers = new ArrayList<>();
                integers.add(element);
                map.put(element, integers);
            } else {
                List<Integer> integers = map.get(element);
                integers.add(element);
            }
        }
        return map;
    }

    @Test
    public void mayFive() {
        System.out.println(classify(Arrays.asList(1, 2, 3, 3, 4, 2)));
    }

    /*
    1.利用键盘录入，输入一个字符串,统计该字符串中各个字符的数量
    2.如用户输入字符串:"helloworld java",程序输出结果：h(1)e(1)l(3)o(2) (2)w(1)r(1)d(1)j(1)a(2)v(1)
    3.注：输出结果不要求顺序一致
     */
    @Test
    public void maySix() {
/*        Scanner sc = new Scanner(System.in);
        System.out.println("please input:");
        String input = sc.nextLine();*/

        String input = "helloworld java";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : map.keySet()) {
            sb.append(c).append("(").append(map.get(c)).append(")");
        }
        System.out.println(sb);
    }

    /*
    键盘录入一个字符串,分别统计出其中英文字母、空格、数字和其它字符的数量,输出结果:”其他=1, 空格=2, 字母=12,数字=6”
     */
    @Test
    public void maySeven() {
        Map<String, Integer> map = new HashMap<>();
        /*        Scanner sc = new Scanner(System.in);
        System.out.println("please input:");
        String input = sc.nextLine();*/
        map.put("其他",0);
        map.put("空格",0);
        map.put("字母",0);
        map.put("数字",0);
        String input = "asdan/f.Akadlf  j2'4$%U90";
        for (char c : input.toCharArray()) {
            if (c == ' '){
                map.put("空格", map.get("空格")+1);
            } else if (c >= 'a' && c <= 'z'){
                map.put("字母", map.get("字母")+1);
            }else if (c >= '0' && c <= '9'){
                map.put("数字", map.get("数字")+1);
            }else{
                map.put("其他", map.get("其他")+1);
            }
        }
        System.out.println(map);
    }

}

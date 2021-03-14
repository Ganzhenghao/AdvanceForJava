package map;

import org.junit.Before;
import org.junit.Test;
import set.bean.Student;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName MapStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/2/27 8:42
 * @Version 1.0
 */
public class MapStudy {
    Map<String,Object> hashMap = new HashMap<>();
    Map<Student,String> treeMap = new TreeMap<>();
    Map<String,Object> linkedHashMap = new LinkedHashMap<>();

    @Before
    public void before() {
        hashMap.put("001", "Dage");
        hashMap.put("002", "heiren");
        hashMap.put("004", "superman");

        treeMap.put(new Student(),"one");
        treeMap.put(new Student(),"two");
        treeMap.put(new Student(),"one");
    }
    @Test
    public void mapOne() {
        System.out.println(hashMap);
    }

    @Test
    public void mapTwo() {
        System.out.println("map.remove(\"002\") = " + hashMap.remove("002"));
        System.out.println("map.put(\"001\",\"what the fc\") = " + hashMap.put("001", "what the fc"));

        System.out.println("map.containsKey(\"003\") = " + hashMap.containsKey("003"));
        System.out.println("map.containsValue(\"Dage\") = " + hashMap.containsValue("Dage"));
        System.out.println("map.get(\"001\") = " + hashMap.get("001"));
        System.out.println("map.isEmpty() = " + hashMap.isEmpty());
        hashMap.clear();
        System.out.println("=========================================");

    }

    @Test
    public void forEachMapOne() {
        for (String key : hashMap.keySet()) {
            System.out.println("map.get(key) = " + hashMap.get(key));
        }
    }

    @Test
    public void forEachMapTwo() {
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            //System.out.println(entry);
            System.out.println("key: "+entry.getKey()+"  --  value: "+entry.getValue());
        }
    }

    @Test
    public void forEachMapThree() {
        hashMap.forEach((s, o) -> System.out.println("key: "+s+"  --  value: "+o));
    }

    @Test
    public void mapPractice() {
        String str = "asdadsfasfdafasdfasdfagdgaf";
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        map.forEach((character, integer) -> System.out.println(character+" 出现了 "+integer+"次"));

    }

    @Test
    public void treeMapOne() {

    }




}

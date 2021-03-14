package concurrent;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HashTableStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/6 16:14
 * @Version 1.0
 */
public class HashTableStudy {
    public static void main(String[] args) {

        Map<String,String> hashMap = new HashMap<>();
        //Map<String,String> hashMap = new Hashtable<>();
        //Map<String,String> hashMap = new ConcurrentHashMap<>();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                hashMap.put(i+"",i+"");
            }
        }).start();
        new Thread(()->{
            for (int i = 100; i < 201; i++) {
                hashMap.put(i+"",i+"");
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //hashMap.forEach((s, s2) -> System.out.println(s+" = "+s2));

        for (int i = 0; i < 201; i++) {
            System.out.println(i + " = "+hashMap.get(i+""));
        }

    }
}

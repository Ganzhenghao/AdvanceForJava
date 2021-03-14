package file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FilePractice
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/2 14:36
 * @Version 1.0
 */
public class FilePractice {

    public static void main(String[] args) {
        Map<String,Integer> hashMap = new HashMap<>();
        File file = new File("JavaDay11");
        //getCount(hashMap,new File("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11"));
        System.out.println(file);
        getCount(hashMap,file);
        System.out.println(hashMap);
    }

    private static void getCount(Map<String, Integer> map, File file) {

        for (File listFile : file.listFiles()) {
            if (listFile.isFile()) {
                String key = listFile.getName().split("\\.")[1];
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            } else {
                getCount(map, listFile);
            }
        }

    }
}

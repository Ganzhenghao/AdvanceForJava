package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName FileStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/2 8:48
 * @Version 1.0
 */
public class FileStudy {

    @Test
    public void one() {
        String path1 = "D:/small";
        String path2 = "a.txt";
/*        String path1 = "D:/small/";
        String path2 = "/a.txt";*/

        //以上两种字符串 输出的是同一种
        System.out.println(new File(path1, path2));

    }

    @Test
    public void two() throws IOException {
        File file = new File("src/main/resources/a.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.createNewFile());

/*        File file = new File("a.txt");
        System.out.println(file.getAbsolutePath());*/
    }

    @Test
    public void three() throws IOException {
        /*
        删除不走回收站
        不能删除非空文件夹
         */
        File file = new File("b.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println("file.createNewFile() = " + file.createNewFile());
        System.out.println("file.delete() = " + file.delete());
    }

    @Test
    public void four() {
        File file = new File("src/main/resources/a.txt");
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void five() throws IOException {
        File file = new File("JavaDay11/a");
        file.mkdirs();
        System.out.println("new File(file, \"a.txt\").createNewFile() = " +
                new File(file, "a.txt").createNewFile());

    }

    @Test
    public void six() {
        File file = new File("D:\\small");
        deleteDir(file);
    }

    private void deleteDir(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File listFile : Objects.requireNonNull(file.listFiles())) {
                    if (listFile.isFile()) {
                        System.out.println(listFile.getName() + "删除了!");
                        listFile.delete();
                    } else {
                        deleteDir(listFile);
                    }
                }
                System.out.println(file.getName() + "删除了!");
                file.delete();
            }
        }
    }

    @Test
    public void seven() {
        Map<String,Integer> hashMap = new HashMap<>();
        File file = new File("JavaDay11");
        //getCount(hashMap,new File("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11"));
        //getCount(hashMap,file);
        System.out.println(hashMap);
    }

    private void getCount(Map<String, Integer> map, File file) {

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


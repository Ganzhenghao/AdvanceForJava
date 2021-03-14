package exam;

import exam.bean.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName One
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/7 14:01
 * @Version 1.0
 */
public class One {
    public static void main(String[] args) {
        File file = new File("JavaDay15/src/main/resources/数据.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(new Person("10086","中国移动",50).toString());
            writer.newLine();
            writer.write(new Person("10010","中国联通",40).toString());
            writer.newLine();
            writer.write(new Person("10000","中国电信",45).toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

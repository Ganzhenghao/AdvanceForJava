package exam;

import exam.bean.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Two
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/7 14:06
 * @Version 1.0
 */
public class Two {
    public static void main(String[] args) {

        //将上述文件数据当中的内容，读取到程序当中，如果公司年龄低于 48岁的公司。
        //将其年龄在之前的基础上增加 20年之后，重新写回到数据文件当中。
        File file = new File("JavaDay15/src/main/resources/数据.txt");
        List<Person> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line;
            while ((line = reader.readLine()) != null) {
/*                if (StringUtils.isEmpty(line)) {
                    continue;
                }*/
                final String[] split = line.split(",");
                if (split.length != 3) {
                    continue;
                }
                int age = Integer.parseInt(split[2]);
                if (age < 48){
                    age += 20;
                }
                list.add(new Person(split[0], split[1],age ));
            }

            final BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size()-1){
                    writer.write(list.get(i).toString());
                }else{
                    writer.write(list.get(i).toString());
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

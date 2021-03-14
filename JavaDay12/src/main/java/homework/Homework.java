package homework;

import homework.bean.Student;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName Homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/4 8:34
 * @Version 1.0
 */
public class Homework {

    private final String path = "src/main/resources/student.txt";
    private final String pre_path = "src/main/resources/";

    /*
    1. 请定义一个Student类，属性：姓名、性别、年龄、分数
	   无参、全参构造方法
	   get/set方法
	2. 定义测试类，编写main()方法：
		//1.定义一个集合
		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student(“张三”,”男”,20,88);
		stuList.add(new Student(“李四”,”女”,19,99);
	3. 遍历这个集合，将每个Student对象中的数据按以下格式写到项目根目录下
	  的student.txt中：
		张三,男,20,88
		李四,女,19,99
     */

    @Test
    public void mustOne() {
        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student("张三", "男", 20, 88));
        stuList.add(new Student("李四", "女", 19, 99));

        try (FileWriter writer = new FileWriter(path)) {
            stuList
                    .forEach(student -> {
                        try {
                            writer.write(student.getName() + ","
                                    + student.getSex() + "," + student.getAge() + "," + student.getGrade());
                            writer.write(System.lineSeparator());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    	1. 定义测试类，编写main()方法
	2. 读取1.1的student.txt文件，一次读取一个字符，显示到控制台。
     */
    @Test
    public void mustTwo() {
        try (FileReader reader = new FileReader(path)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.println(((char) ch));
            }
        } catch (IOException e) {
        }
    }

    /*
    		请编写程序，定义一个Properties对象，存储以下内容：
			Properties pro = new Properties();
			pro.setProperty(“品名”,”Iphone11 Pro Max”);
			pro.setProperty(“颜色”,”暗夜绿”);
			pro.setProperty(“存储容量”,”256G”);
			pro.setProperty(“价格”,”10899”);
			//请将上述内容写入到文件：”test2_1.txt”中
     */
    @Test
    public void mustThree() {
        Properties properties = new Properties();
        properties.setProperty("品名", "Iphone11 Pro Max");
        properties.setProperty("颜色", "暗夜绿");
        properties.setProperty("存储容量", "256G");
        properties.setProperty("价格", "10899");
        try (FileWriter writer = new FileWriter(pre_path + "test2_1.txt")) {
            properties.store(writer, null);
        } catch (IOException e) {
        }
    }

    /*
    		请编写main()方法，定义一个存储String的集合：List<String>，并初始化以下数据：
			List<String> list = new ArrayList<>();
			list.add(“迪丽热巴”);
			list.add(“古力娜扎”);
			list.add(“周杰伦”);
			list.add(“蔡徐坤”);
			//请定义“字符缓冲输出流”BufferedWriter将集合中的数据写入到文件：test3_1.txt中，每个名字一行。
     */
    @Test
    public void mustFour() {
        List<String> list = new ArrayList<>();
        list.add("迪丽热巴");
        list.add("古力娜扎");
        list.add("周杰伦");
        list.add("蔡徐坤");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pre_path + "test3_1.txt"))) {

            list.forEach(s -> {
                try {
                    writer.write(s + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
/*            list.forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    w
                }
            });*/

        } catch (IOException e) {

        }
    }


    /*
    		请编写main()方法，定义一个字符缓冲输入流BufferedReader，读取test3_1.txt文件，
    		一次读取一行，将读取的内容存储到一个List<String>集合中，遍历、并打印集合中的每个元素：
			//1.定义一个字符缓冲输入流
			BufferedReader in = new BufferedReader(......);
			//2.定义一个集合
			List<String> list = new ArrayList<>();
			//3.一次读取一行
			......
			......
     */
    @Test
    public void mustFive() {
        try (BufferedReader reader = new BufferedReader(new FileReader(pre_path + "test3_1.txt"))) {
            List<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            list.forEach(System.out::println);
        } catch (IOException e) {

        }
    }

    /*
    请按以下要求编写程序：
		1).定义一个学员类，有以下属性：姓名、性别、年龄、分数
		  无参、全参构造方法，get/set方法
		2).定义main()方法，定义一个存储Student的集合，并初始化一些数据：
			List<Student> stuList = new ArrayList<>();
			stuList.add(new Student(“迪丽热巴”,”女”,18,99);
			stuList.add(new Student(“古力娜扎”,”女”,19,98);
			stuList.add(new Student(“周杰伦”,”男”,20,88);
			stuList.add(new Student(“蔡徐坤”,”男”,19,78);
			/*
			定义一个字符缓冲输出流BufferedWriter，将学员信息写入到”test3_3.txt”中，
            每个学员信息占一行，每个字段之间用,符号隔开，例如：
				迪丽热巴,女,18,99
				古力娜扎,女,19,98
				周杰伦,男,20,88
				蔡徐坤,男,19,78
     */

    @Test
    public void mustSix() {
        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student("迪丽热巴", "女", 18, 99));
        stuList.add(new Student("古力娜扎", "女", 19, 98));
        stuList.add(new Student("周杰伦", "男", 20, 88));
        stuList.add(new Student("蔡徐坤", "男", 19, 78));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pre_path + "test3_3.txt"))) {
            for (Student student : stuList) {
                writer.write(student.getName() + "," + student.getSex() + ","
                        + student.getAge() + "," + student.getGrade() + System.lineSeparator());
            }
        } catch (IOException e) {

        }
    }


    /*
    		请编写main()方法，定义一个字符缓冲输入流BufferedReader对象，读取”test3_3.txt”文件，一次读取一行，
    		将每行数据封装为一个Student对象，并将Student对象存储到一个集合。遍历并打印集合的所有Student信息。
		//定义一个BufferedReader对象
		BufferedReader in = new BufferedReader(......);
		//定义一个集合
		List<Student> stuList = new ArrayList<>();
		//一次读取一行
		......
     */

    @Test
    public void mustSeven() {
        try (BufferedReader reader = new BufferedReader(new FileReader(pre_path + "test3_3.txt"))) {
            String line;
            List<Student> stuList = new ArrayList<>();
            while ((line = reader.readLine()) != null){
                String[] split = line.split(",");
                stuList.add(new Student(split[0],split[1],Integer.parseInt(split[2]),Integer.parseInt(split[3])));
            }
            System.out.println(stuList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    	请定义一个输出转换流对象：OutputStreamWriter，
    	使用GBK编码，向文件”test4_1.txt”文件输出内容：”我要学好Java，我要月薪过万！！”
     */
    @Test
    public void mustEight() {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(pre_path + "test4_1.txt"), Charset.forName("GBK"))) {
            writer.write("我要学好Java，我要月薪过万！！");
        } catch (IOException e) {
        }
    }

    /*
    	请定义一个输入转换流对象：InputStreamReader，使用GBK编码读取“test4_1.txt”文件的内容，并打印。
     */

    @Test
    public void mustNine() {
        try (InputStreamReader reader = 
                     new InputStreamReader(new FileInputStream(pre_path + "test4_1.txt")
                             , Charset.forName("GBK"))) {
            int ch;
            while ((ch = reader.read()) != -1){
                System.out.println(((char) ch));
            }
        } catch (IOException e) {
        }
    }

    /*
    	请定义Student类，有以下属性：姓名、性别、年龄，并实现Serializable接口。
	请定义main()方法，创建一个Student对象：
		Student stu = new Student(“迪丽热巴”,”女”,18);
		//定义一个序列化对象：ObjectOutputStream，将stu序列化到文件“test5_1.txt”中
     */
    @Test
    public void mustTen() {
        Student student = new Student("迪丽热巴", "女", 18, 55);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pre_path + "test5_1.txt"))) {
            oos.writeObject(student);
        } catch (IOException e) {
        }
    }


    /*
    	请定义main()方法，
    	创建一个反序列化对象：ObjectInputStream，将文件”test5_1.txt”的对象反序列化到程序中，并打印此对象。
     */
    @Test
    public void mustEleven() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pre_path + "test5_1.txt"))) {
            Student student = (Student) ois.readObject();
            System.out.println("student = " + student);
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}

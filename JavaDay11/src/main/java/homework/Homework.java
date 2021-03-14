package homework;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

/**
 * @ClassName Homework
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/2 8:47
 * @Version 1.0
 */
public class Homework {

    /*
    	请在D盘根目录下创建一个文件：test1.txt(随意录入一些内容)，再创建一个目录：测试目录
	请编写main()方法，创建以下两个File对象：
		File file1 = new File(“d:\\test1.txt”;
		File file2 = new File(“d:\\测试目录”);
	要求：
		1. 获取、打印file1和file2的绝对路径；
		2. 获取、打印file1和file2的文件名和目录名；
		3. 获取、打印file1和file2的文件大小；
		4. 分别判断file1和file2是否存在；
		5. 分别判断file1和file2是否是文件？是否是目录？
     */
    @Test
    public void mustOne() {
        File f1 = new File("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11\\src\\main\\resources\\a.txt");
        File f2 = new File("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11\\src\\main\\resources\\测试目录");
        System.out.println("f1.getAbsolutePath() = " + f1.getAbsolutePath());
        System.out.println("f2.getAbsolutePath() = " + f2.getAbsolutePath());

        System.out.println("f1.getName() = " + f1.getName());
        System.out.println("f2.getName() = " + f2.getName());

        System.out.println("f1.length() = " + f1.length());
        System.out.println("f2.length() = " + f2.length());

        System.out.println("f1.exists() = " + f1.exists());
        System.out.println("f2.exists() = " + f2.exists());

        System.out.println("f1.isDirectory() = " + f1.isDirectory());
        System.out.println("f1.isFile() = " + f1.isFile());

        System.out.println("f2.isDirectory() = " + f2.isDirectory());
        System.out.println("f2.isFile() = " + f2.isFile());

    }

    /*
    	请编写main()方法，创建以下File对象：
		File file1 = new File(“test.txt”);//相对路径，在项目根目录下
		File file2 = new File(“一级目录”);
		File file3 = new File(“目录A/目录B/目录C”);
	要求：
		1. 判断file1是否存在？如果不存在，创建这个文件。
		2. 判断file2是否存在？如果不存在，创建这个目录。
		3. 判断file3是否存在？如果不存在，创建这个多级目录。
     */
    @Test
    public void mustTwo() {
        //TODO  exists()  mkdirs()
    }

    /*
    请在D盘下创建一个目录“多级目录”，下面随意创建一些文件和目录。
	请编写main()方法，创建以下File对象：
		File file = new File(“D:\\多级目录”);
	要求：
		1. 获取这个file目录下所有的子文件/子目录的File数组
		2. 遍历这个数组，判断每个File对象是否文件
			如果是文件，打印：【文件】+ 绝对路径
			如果是目录，打印：【目录】+ 绝对路径
     */
    @Test
    public void mustThree() {
        final File file = new File("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11");
        recursivePrintingPath(file);
    }

    private void recursivePrintingPath(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                if (listFile.isFile()) {
                    System.out.println("[" + listFile.getName() + "] " + listFile.getAbsolutePath());
                } else {
                    recursivePrintingPath(listFile);
                }
            }
        }
    }

    @Test
    public void mustFour() {
        // TODO 如上
    }

    /*
    描述:利用字节输出流一次写一个字节的方式，向D盘的a.txt文件输出字符‘a’。
     */
    @Test
    public void mayOne() {
        final File file = new File("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11\\src\\main\\resources\\a.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(97);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    需求：利用字节输出流一次写一个字节数组的方式向D盘的b.txt文件输出内容:"i love java"。
     */
    @Test
    public void mayTwo() {
        final File file = new File("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11\\src\\main\\resources\\b.txt");
        String s = "i love java";
        try (FileOutputStream fos = new FileOutputStream(file)) {
            for (byte b : s.getBytes(StandardCharsets.UTF_8)) {
                fos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    1. 利用字节输入流读取F盘文件a.txt的内容，文件内容确定都为纯ASCII字符，使用循环读取，一次读取一个字节，直到读取到文件末尾。
2. 将读取的字节输出到控制台
     */

    @Test
    public void mayThree() {
        final File file = new File("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11\\src\\main\\resources\\a.txt");
        try (FileInputStream fis = new FileInputStream(file)) {
            int read;
            while (((read = fis.read()) != -1)) {
                System.out.println((char)read);
            }
        } catch (IOException ignored) {
        }
    }

    /*
    需求：利用字节输入流读取D盘文件b.txt的内容，文件内容确定都为纯ASCII字符，使用循环读取，一次读取一个字节数组，直到读取到文件末尾，并将读取到的字节数组转换成字符串输出到控制台。
     */
    @Test
    public void mayFour() {
        final File file = new File("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11\\src\\main\\resources\\a.txt");

        byte[] bytes = new byte[8];

        try (FileInputStream fis = new FileInputStream(file)) {
            while ((fis.read(bytes) != -1)){
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    从控制台循环接收用户录入的学生信息，输入格式为：学号-学生名字  将学生信息保存到F盘下面的stu.txt文件中，一个学生信息占据一行数据。当用户输入end时停止输入。
     */
    @Test
    public void mayFive() {
        Scanner sc = new Scanner(System.in);
        File file = new File("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11\\src\\main\\resources\\c.txt");
        String input;
        int index = 1;
        try (FileOutputStream fos = new FileOutputStream(file)) {
            while (true){
                System.out.print("请输入第"+index+"个学生的数据(end to exit):");
                input = sc.nextLine();
                if ("end".equals(input)){return;}
                fos.write(input.getBytes(StandardCharsets.UTF_8));
                fos.write("\r\n".getBytes(StandardCharsets.UTF_8));
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package io;

import bean.User;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName CharStreamStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/4 8:41
 * @Version 1.0
 */
public class CharStreamStudy {

    @Test
    public void one() throws UnsupportedEncodingException {
        byte[] utf8 = "儿砸,儿砸,我是你爸爸".getBytes(StandardCharsets.UTF_8);
        byte[] gbk = "儿砸,儿砸,我是你爸爸".getBytes("GBK");

        System.out.println("utf8 = " + Arrays.toString(utf8));
        System.out.println("gbk = " + Arrays.toString(gbk));

        System.out.println("new String(utf8) = " + new String(utf8));
        System.out.println("new String(gbk) = " + new String(gbk));
        System.out.println("new String(gbk,\"GBK\") = " + new String(gbk, "GBK"));
    }

    @Test
    public void two() {
        try (FileWriter writer = new FileWriter("src/main/resources/a.txt")) {
            writer.write(97);
            char[] chars = {97, 98, 99};
            writer.write(chars);
            writer.write("我爱学习");
            writer.write("我我我我", 0, 2);
            System.out.println(new File("").getAbsolutePath());
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    @Test
    public void three() throws IOException {
        FileWriter writer = new FileWriter("src/main/resources/a.txt");
        writer.write("good good study");
        //writer.flush();
        writer.write("day day up");
        writer.close();
        writer.write("aaa");
    }

    /*
    创建一个3G的文件
     */
    @Test
    public void creatFile() throws IOException {
        FileWriter writer = new FileWriter("src/main/resources/oneGB.txt");
        for (int i = 0; i < 100000000; i++) {
            writer.write("good good study, day day up !\r\n");
        }
        writer.close();
        System.out.println("创建完成");
    }

    /*

     */
    @Test
    public void time() throws IOException {
        File file = new File("src/main/resources/oneGB.txt");

        // 字节读取
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("src/main/resources/byte.txt");
        byte[] bytes = new byte[8192];
        int len;

        // 开始时间节点
        long byteStart = System.currentTimeMillis();
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        // 结束时间节点
        long byteEnd = System.currentTimeMillis();

        //缓冲字节读取

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/main/resources/buffer.txt"));
        byte[] buffer = new byte[8192];
        len = 0;
        // 开始时间节点
        long bufferStart = System.currentTimeMillis();
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        // 结束时间节点
        long bufferEnd = System.currentTimeMillis();


        fis.close();
        fos.close();
        bis.close();
        bos.close();

        System.out.println("字节数组使用的时间为:" + (byteEnd - byteStart));
        System.out.println("缓冲字节数组使用的时间为:" + (bufferEnd - bufferStart));

        if ((byteEnd - byteStart) > (bufferEnd - bufferStart)) {
            System.out.println("字节数组使用的时间长");
        } else {
            System.out.println("缓冲字节数组使用的时间长");
        }

    }


    @Test
    public void four() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please input username:");
        String username = sc.nextLine();
        System.out.println("please input password:");
        String password = sc.nextLine();
        try (FileWriter fileWriter = new FileWriter("src/main/resources/user.txt")) {
            fileWriter.write(username + "\r\n");
            fileWriter.write(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void five() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/a.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/a.txt"))) {
            writer.write("Good Good Study Day Day Up!");
            writer.flush();
            char[] chars = new char[1024];
            int len;
            while ((len = reader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void six() {
        //System.out.println("good "+System.lineSeparator()+"day");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/sort.txt"));
            String line;
            Integer[] array = null;
            while ((line = reader.readLine()) != null) {
                final String[] strings = line.split(" ");
                array = Arrays.stream(strings).map(Integer::parseInt).sorted().toArray(Integer[]::new);
                System.out.println(Arrays.toString(array));
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/sort.txt"));
            if (array != null) {
                for (Integer integer : array) {
                    writer.write(integer + " ");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //转换流  JDK11 以前
    @Test
    public void seven() {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("src/main/resources/b.txt"), "GBK")) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print(((char) ch));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //转换流 JDK11 以后
    @Test
    public void eight() {
        try (FileReader reader = new FileReader("src/main/resources/b.txt", Charset.forName("GBK"))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print(((char) ch));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void nine() {
        User user = new User("儿砸,儿砸", "我是你爸爸");
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("src/main/resources/user.txt"))) {
            write.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ten() {

        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream("src/main/resources/user.txt"))) {
            User user = (User) read.readObject();
            System.out.println(user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void eleven() {
        User user = new User("儿砸,儿砸", "我是你爸爸");
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("src/main/resources/user.txt"))) {
            ArrayList<User> users = new ArrayList<>();
            users.add(user);
            users.add(new User("孙砸,孙砸", "我是你爷爷"));
            write.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream("src/main/resources/user.txt"))) {
            ArrayList<User> users = (ArrayList<User>) read.readObject();
            System.out.println(users);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }




}

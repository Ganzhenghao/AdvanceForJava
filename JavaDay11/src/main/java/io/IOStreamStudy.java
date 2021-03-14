package io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName IOStreamStudy
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/2 8:49
 * @Version 1.0
 */
public class IOStreamStudy {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("JavaDay11/src/main/resources/c.txt");
        fileOutputStream.write(97);
        fileOutputStream.close();
    }

    @Test
    public void one() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("c.txt");
        fileOutputStream.write(97);
        fileOutputStream.close();
    }

    @Test
    public void two() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("c.txt");
        byte[] bytes = new byte[26];
        int index = 0;
        for (int i = 97; i < 123; i++) {
            bytes[index] = (byte) i;
            index ++;
        }

        fileOutputStream.write(bytes, 0, bytes.length);
        fileOutputStream.close();
    }

    @Test
    public void three() throws IOException{

        FileOutputStream fileOutputStream = new FileOutputStream("c.txt");
        //byte[] bytes = new byte[20];
        for (int i = 97; i < 123; i += 2) {
            fileOutputStream.write((byte) i);
            fileOutputStream.write("\r\n".getBytes(StandardCharsets.UTF_8));
        }

        fileOutputStream.close();
    }

    @Test
    public void autoClose(){
        try (FileOutputStream fileOutputStream = new FileOutputStream("c.txt")){
            for (int i = 97; i < 123; i += 2) {
                fileOutputStream.write((byte) i);
                fileOutputStream.write("\r\n".getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void four() {
        try (FileInputStream fis= new FileInputStream("c.txt")) {

            int read = fis.read();
            System.out.println(((char) read));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void five() {
        try (FileInputStream fis = new FileInputStream("c.txt")) {
            int read;
            while ((read = fis.read()) != -1) {
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void six() {
        try (FileInputStream fis = new FileInputStream("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11\\src\\main\\resources\\嘿嘿嘿.avi");
             FileOutputStream fos = new FileOutputStream("a.avi")) {
            int read;
            while ((read = fis.read()) != -1){
                fos.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void seven() {
        try (FileInputStream fis = new FileInputStream("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11\\src\\main\\resources\\嘿嘿嘿.avi");
             FileOutputStream fos = new FileOutputStream("a.avi")) {
            // 8 bit = 1 byte
            // 1024 byte = 1 kb
            // 1024 kb = 1 mb
            byte[] read = new byte[1024*1024];
            int len;
            while ((len = fis.read(read)) != -1){
                System.out.println(len);
                fos.write(read,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void eight() {


        try (FileInputStream fis = new FileInputStream("D:\\Develop\\JavaPrograms\\AdvanceForJava\\JavaDay11\\src\\main\\resources\\嘿嘿嘿.avi");
             FileOutputStream fos = new FileOutputStream("a.avi");
             BufferedInputStream in = new BufferedInputStream(fis);
             final BufferedOutputStream out = new BufferedOutputStream(fos)
        ) {
            int read;
            while ((read = in.read()) != -1) {
//                System.out.println(read);
                out.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}

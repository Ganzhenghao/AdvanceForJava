import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName Reader
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/2 9:47
 * @Version 1.0
 */
public class Reader {
    public static void main(String[] args) throws IOException {
        //System.out.println(new File("src/main/resources/a.txt").getAbsolutePath());
        //System.out.println(new File("JavaDay11/src/main/resources/a.txt").getAbsolutePath());
        InputStreamReader in = new InputStreamReader(new FileInputStream("JavaDay11/src/main/resources/a.txt"), StandardCharsets.UTF_8);
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream("JavaDay11/src/main/resources/b.txt"),StandardCharsets.UTF_8);

        char[] chars = new char[8];
        int read ;
        while ((read = in.read(chars)) != -1){
            out.write(chars, 0, read);
        }
        in.close();
        out.close();
        System.out.println("拷贝完成!");
    }

}

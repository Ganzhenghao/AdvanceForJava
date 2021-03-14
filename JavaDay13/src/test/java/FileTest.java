import java.io.File;

/**
 * @ClassName FileTest
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/4 21:13
 * @Version 1.0
 */
public class FileTest {

    public static void main(String[] args) {
        for (File file : File.listRoots()) {
            System.out.println(file.getAbsolutePath());
        }
    }

}

package homework;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName MustTwoClient
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 18:19
 * @Version 1.0
 */
public class MustTwoClient {
    public static void main(String[] args) {

//        请编写客户端向服务器端上传的案例，要求上传完毕，服务器端要向客户端发送一条反馈信息，客户端收到反馈后打印到控制台，两端结束。
        try (Socket socket = new Socket("127.0.0.1", 5555)) {

            final BufferedInputStream bis = new BufferedInputStream(new FileInputStream("JavaDay15/src/main/resources/count.properties"));

            byte[] bytes = new byte[8192];
            int len;

            final BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

            while ((len = bis.read(bytes)) != -1){
                bos.write(bytes, 0, len);
            }

            bos.flush();
            socket.shutdownOutput();


            final BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }


            bis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

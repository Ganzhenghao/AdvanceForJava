package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @ClassName MustTwoServer
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 18:20
 * @Version 1.0
 */
public class MustTwoServer {
    public static void main(String[] args) {

        //        请编写客户端向服务器端上传的案例，要求上传完毕，服务器端要向客户端发送一条反馈信息，客户端收到反馈后打印到控制台，两端结束。

        try (ServerSocket serverSocket = new ServerSocket(5555);
             final Socket socket = serverSocket.accept()) {

            final BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            final BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("JavaDay15/src/main/java/homework/data/" + UUID.randomUUID().toString().replace("-", "")+"copy.properties"));

            byte[] bytes = new byte[8192];
            int len;

            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }

            final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

            writer.write("上传成功!");
            writer.flush();
            socket.shutdownOutput();

        } catch (IOException e) {
        }


    }
}

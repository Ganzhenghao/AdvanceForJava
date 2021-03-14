package homework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName MustOneClient
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 18:13
 * @Version 1.0
 */
public class MustOneClient {
    public static void main(String[] args) {
//        1. 请定义TCP的客户端，向服务器端发送一条信息：你好，我是客户端小白。

        try (Socket socket = new Socket("127.0.0.1", 5555)) {
            final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

            writer.write("你好，我是客户端小白。");
            writer.flush();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

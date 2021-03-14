package homework;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName MayOneClient
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 18:52
 * @Version 1.0
 */
public class MayOneClient {
    public static void main(String[] args) {
//        1. 在项目下创建TCP 服务器端 端口号为8888
//        2. 等待客户端连接，如果有客户端连接则获取到客户端对象
//        3. 在获取到客户端对象之后 在服务器读取客户端传送的数据

        try (Socket socket = new Socket("127.0.0.1", 8888)) {


            final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
            writer.write("hello.服务器,我是客户端.");
            writer.flush();

            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

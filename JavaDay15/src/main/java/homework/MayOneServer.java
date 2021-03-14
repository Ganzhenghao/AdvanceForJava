package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName MayOneServer
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 18:53
 * @Version 1.0
 */
public class MayOneServer {
    public static void main(String[] args) {
        //        1. 在项目下创建TCP 服务器端 端口号为8888
//        2. 等待客户端连接，如果有客户端连接则获取到客户端对象
//        3. 在获取到客户端对象之后 在服务器读取客户端传送的数据
        try (ServerSocket serverSocket = new ServerSocket(8888);
             final Socket socket = serverSocket.accept();) {

            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            String line;

            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

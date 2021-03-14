package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName MustOneServer
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 18:13
 * @Version 1.0
 */
public class MustOneServer {
    public static void main(String[] args) {
        //        2. 请定义TCP的服务器端，接收这条信息，并打印到控制台
        try (ServerSocket serverSocket = new ServerSocket(5555);
             Socket socket = serverSocket.accept();
             final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));) {
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

package homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @ClassName MayFourServer
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/9 19:16
 * @Version 1.0
 */
public class MayFourServer {
    public static void main(String[] args) throws IOException {
//        需求：使用TCP协议实现客户端和服务端互相发送消息。
//        客户端发送一条消息，服务器读取之后，返回一条消息给客户端，客户端读取服务器返回的消息之后，又发送一条消息…循环执行，直到输入exit。
//        要求:
//        1. 消息内容通过键盘输入
//        2. 要求服务器端和客户端都使用字符流的方式发送和接收数据。
//        使用BufffferedReader方法readLine()读取一行数据。
//        使用BufffferedWriter方法write("字符串的数据")发送数据。
        String username = "Server: ";
        Scanner sc = new Scanner(System.in);
        String line;
        final ServerSocket serverSocket = new ServerSocket(8888);
        while (true){

            try(final Socket socket = serverSocket.accept();
                final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
                final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));) {

                while ((line = reader.readLine()) != null){
                    System.out.println(line);
                }

                System.out.print(username);
                line = sc.nextLine();


                writer.write(username + line);
                writer.flush();
                socket.shutdownOutput();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

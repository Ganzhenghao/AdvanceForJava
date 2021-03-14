package internet.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @ClassName TCPServer2
 * @Description TODO
 * @Author Ganzhenghao
 * @Date 2021/3/8 14:55
 * @Version 1.0
 */
public class TCPServer2 {
    public static void main(String[] args) throws IOException {
        final Scanner sc = new Scanner(System.in);
        String username = "Server";
        final ServerSocket serverSocket = new ServerSocket(5555);
        try{
            while (true) {
                Socket socket = serverSocket.accept();
                final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                System.out.print(username + ":");
                line = sc.nextLine();
                if ("exit".equals(line)){break;}
                line = username + ":" +line;

                writer.write(line);
                writer.flush();
                socket.shutdownOutput();
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        serverSocket.close();
    }
}
